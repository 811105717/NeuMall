package com.neusoft.mall.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebConfig
 * @Description: 注册拦截器
 * @Author: shengtt
 * @Date: 2019/3/26
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessHandler())
                .addPathPatterns("/**")
                //添加需要进行拦截的链接
                .excludePathPatterns("/front/account/userLogin");
        //排除不需要拦截的链接，多个链接直接用逗号隔开
        System.out.println("===========   拦截器注册完毕   ===========");
    }
}
