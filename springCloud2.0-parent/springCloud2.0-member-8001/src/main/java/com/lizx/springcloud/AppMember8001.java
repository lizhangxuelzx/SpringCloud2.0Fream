package com.lizx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by lzx on 2018-12-14.
 */
@SpringBootApplication
@EnableEurekaClient
public class AppMember8001 {
    public static void main(String[] args) {
        SpringApplication.run(AppMember8001.class,args);
    }
}
