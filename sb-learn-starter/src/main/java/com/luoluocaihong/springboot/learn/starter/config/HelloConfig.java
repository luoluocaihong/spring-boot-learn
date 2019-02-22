package com.luoluocaihong.springboot.learn.starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xh on 2019/2/22.
 */
@Configuration
public class HelloConfig {

    @Bean
    public String getName() {
        return "Hello,luoluocaihong!";
    }
}
