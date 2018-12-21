package com.lizx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by lzx on 2018-12-14.
 */
@SpringBootApplication
@EnableEurekaClient
public class AppMember8002 {
    public static void main(String[] args) {
        SpringApplication.run(AppMember8002.class,args);
    }
}
