package com.neusoft.mall.util;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName: AccessHandler
 * @Description:登录检查
 * @Author: shengtt
 * @Date: 2019/3/26
 */
@SuppressWarnings("ALL")
@Slf4j
@Deprecated
public class AccessHandler implements HandlerInterceptor {
    /**
     * 不希望被拦截的路由
     */
    final String[] passPath = new String[]
        {   "/error",
             "/front/account/registered",
             "/front/account/userLogin",
             "/front/commodity/getRecommondCommodityList",
             "/front/commodity/getClassifyList",
             "/front/commodityCenter/getCommodityList",
             "/front/commodityCenter/getCommodityCenterDeatil",
             "/front/commodityCenter/getCommodityCenterSimilar",
             "/front/commodityCenter/getCommodityCenterTrading",
             "/backend/user/Login"
            };

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //允许跨域
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //打印访问信息
        log.info("请求：{}",request.getRequestURL());
        //不在拦截范围内
        for(String path:passPath){
            if(request.getServletPath().equals(path)){
                log.info("不拦截路由{}",path);
                return true;
            }
        }
        //token验证
        String key = request.getParameter("tokenFront");
        if(null==key){
            key = request.getParameter("tokenBackend");
        }
        if(null!=key){
            log.info("得到token {}",key);
            Object data = redisUtil.getData(key);
            if(null!=data){
                //延长token时间
                boolean res = redisUtil.updateActiveTime(key);
                if(res){
                    log.info("比对token 成功，更新存活时间！{}",key);
                    return true;
                }
            }
        }
        //没有token 返回提示用户登录
        log.info("未查询到相关token信息，拦截请求！");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("code",1);
        obj.put("msg","权限不足，请您重新登陆！");
        obj.put("data","");
        out.print(obj.toString());
        return false;
    }
}
