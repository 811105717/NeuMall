package com.neusoft.gateway.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xiaobai
 * @Date: 2019/4/24 10:23
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Configuration
public class WebConfig {
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
