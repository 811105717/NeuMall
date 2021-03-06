package com.neusoft.mall.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebConfig
 * @Description: 拦截器配置 已经不再使用
 * @Author: xiaobai
 * @Date: 2019/3/26
 */
@SuppressWarnings("ALL")
//@Configuration
@Deprecated
public class WebConfig implements WebMvcConfigurer {
    /**
     * @Dept 大连东软信息学院
     * @Description
     * @Author xiaobai
     * @Date: 2019/4/20
     * @Param：
     * @Return com.neusoft.mall.util.AccessHandler
     */
    @Bean
    public AccessHandler accessHandler(){
        return new AccessHandler();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessHandler()).addPathPatterns("/**");
    }
}
