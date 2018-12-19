package com.lizx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by lzx on 2018-12-19.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer8888 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer8888.class,args);
    }
}
