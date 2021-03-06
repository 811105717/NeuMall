package com.neusoft.gateway.util;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xiaobai
 * @Date: 2019/4/24 10:06
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Slf4j
@SuppressWarnings("ALL")
public class AccessFilter extends ZuulFilter {
    /**
     * 不希望被拦截的路由
     */
    static final String[] PASS_PATH = new String[]
            {   "/error","/mall/error",
                "/mall/front/account/registered",
                "/mall/front/account/userLogin",
                "/mall/front/commodity/getRecommondCommodityList",
                "/mall/front/commodity/getClassifyList",
                "/mall/front/commodityCenter/getCommodityList",
                "/mall/front/commodityCenter/getCommodityCenterDeatil",
                "/mall/front/commodityCenter/getCommodityCenterSimilar",
                "/mall/front/commodityCenter/getCommodityCenterTrading",
                "/mall/admin/backend/login/userLogin"
            };
    /**
     * 跨域探测请求方法
     */
    static final String PASS_METHOD = "OPTIONS";

    /**
     * redis工具
     */
    @Autowired
    private RedisUtil<Object> redisUtil;

    /**
     * 过滤类型 路由之前
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /**
     * 过滤顺序
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否过滤
     */
    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //跨域请求不拦截
        if(request.getMethod().equals(AccessFilter.PASS_METHOD)){
            log.info("跨域探测请求不拦截");
            return false;
        }
        //不拦截的路由
        for(String pass:AccessFilter.PASS_PATH){
            if(request.getServletPath().equals(pass)){
                log.info("不拦截路由 ：{}",request.getServletPath());
                return false;
            }
        }
        log.info("拦截路由 ：{} ",request.getServletPath());
        return true;
    }

    /**
     *拦截判定
     */
    @Override
    public Object run() throws ZuulException {
        //是否进行拦截
        boolean permission = false;
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //token验证 取值步骤 1.前台 2.后台 3.header
        String key = request.getParameter("tokenFront");
        if(null == key){
            key = request.getParameter("tokenBackend");
        }
        if(null == key){
            key = (String) request.getHeader("token");
        }

        if(null!=key){
            Object data = redisUtil.getData(key);
            if(null!=data){
                //延长token时间
                boolean res = redisUtil.updateActiveTime(key);
                if(res){
                    log.info("比对token {} 成功，更新token存活时间！",key);
                    permission = true;
                }
            }
        }
        //如果验证失败
        if(!permission){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(800);
            requestContext.getResponse().setContentType("application/json; charset=utf-8");
            JSONObject obj = new JSONObject();
            obj.put("code",2);
            obj.put("msg","权限不足，请您重新登陆！");
            obj.put("data","");
            requestContext.setResponseBody(obj.toString());
            log.info("token= {} 无效  拦截请求 {}",key,request.getServletPath());
        }
        return null;
    }
}
