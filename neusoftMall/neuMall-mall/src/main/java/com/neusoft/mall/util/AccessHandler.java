package com.neusoft.mall.util;

import com.neusoft.mall.entity.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @ClassName: AccessHandler
 * @Description:登录检查
 * @Author: shengtt
 * @Date: 2019/3/26
 */

@Configuration
@Slf4j
public class AccessHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        // 如果session不为空，则可以浏览其他页面
        CustomerInfo user = (CustomerInfo) session.getAttribute("_LOGIN_USER_");
        if("".equals(user) || null == user){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter prw = response.getWriter();
            prw.print("session失效，请重新登录");
            log.info("session失效，请重新登录");
            return false;
        }else {
            log.info("已登录");
            return true;
        }
    }

}
