package com.neusoft.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: NeuMallGatewayApplication
 * @Description: 启动类
 * @author: xiaobai
 * @Date: 2019/4/8
 */
@SuppressWarnings("ALL")
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class NeuMallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeuMallGatewayApplication.class, args);
    }

}
