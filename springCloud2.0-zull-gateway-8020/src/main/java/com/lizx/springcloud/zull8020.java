package com.lizx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.beans.ConstructorProperties;

/**
 * Created by lzx on 2018-12-19.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class zull8020 {

    public static void main(String[] args) {
        SpringApplication.run(zull8020.class,args);
    }

    // zuul配置能够使用config实现实时更新
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
