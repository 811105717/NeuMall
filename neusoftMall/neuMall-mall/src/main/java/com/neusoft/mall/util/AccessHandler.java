package com.neusoft.mall.util;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
@Configuration
@Slf4j
public class AccessHandler implements HandlerInterceptor {
    //不希望被拦截的请求路由
    final String[] passPath = new String[]
            {"error",
             "/front/account/registered",
             "/front/account/userLogin",
             "/admin/backend/login/userLogin",
             "/admin/backend/user/updatePwd",
             };
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //跨域
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //是否支持cookie跨域
        log.info("来自：{}",request.getHeader("Origin"));
        log.info("请求：{}",request.getRequestURL());
        //不在拦截范围内
        for(String path:passPath){
            if(request.getServletPath().equals(path)){
                log.info("不拦截路由{}",path);
                return true;
            }
        }
        //拿到 token key  进行验证
        String key = request.getParameter("tokenFront");
        if(null==key){
            log.info("前台token获取失败 获取后台token");
            key = request.getParameter("tokenBackend");
        }
        if(null!=key){
            //获取用户信息  成功就不拦截
            Object data = redisUtil.getData(key);
            if(null!=data){
                log.info("查询到token 通过拦截！{}",key);
                //延长token时间
                boolean res = redisUtil.updateActiveTime(key);
                if(res){
                    log.info("获取token 成功，更新存活时间！{}",key);
                }
                return true;
            }
        }
        log.info("未查询到相关token信息，拦截请求！ {}",key);
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("code",1);
        obj.put("msg","操作被拦截");
        obj.put("data",null);
        out.print(obj.toJSONString());
        return false;
    }
}
