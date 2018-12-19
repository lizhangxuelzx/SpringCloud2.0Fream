package com.lizx.springcloud.myribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by lzx on 2018-12-19.
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRule(){
        return new PollRule();
    }
}
