package com.luoluocaihong.springboot.learn.starter.config;

import com.luoluocaihong.springboot.learn.starter.aware.SpringContextAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xh on 2019/2/23.
 */
@Configuration
@ConditionalOnProperty(prefix = "luoluocaihong.spring.context.aware", value = "enabled")
public class SpringContextAwareConfig {


    @Bean
    public SpringContextAware springContextAware() {
        return new SpringContextAware();
    }
}
