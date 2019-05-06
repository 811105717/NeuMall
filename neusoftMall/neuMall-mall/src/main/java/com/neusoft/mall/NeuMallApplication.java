package com.neusoft.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: xiaoabai
 * @Date: 2019/4/8 16:27
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@SpringBootApplication
@EnableEurekaServer
@EnableSwagger2
public class NeuMallApplication  {
    public static void main(String[] args) {
        SpringApplication.run(NeuMallApplication.class,args);
    }
}
