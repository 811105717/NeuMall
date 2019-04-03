package com.neusoft.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: TestEurekaApplication
 * @Description:
 * @Author: shengtt
 * @Date: 2019/4/1
 */
@SpringBootApplication
@EnableEurekaServer
@MapperScan(value ="com.**.dao")
public class NeuMallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeuMallAdminApplication.class, args);
    }

}