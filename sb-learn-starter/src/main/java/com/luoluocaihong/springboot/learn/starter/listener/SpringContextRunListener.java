package com.luoluocaihong.springboot.learn.starter.listener;

import com.luoluocaihong.springboot.learn.starter.util.SpringContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by xh on 2019/2/23.
 */
public class SpringContextRunListener implements SpringApplicationRunListener {

    public static final String BOOTSTRAP_PROPERTY_SOURCE_NAME = "bootstrap";

    public SpringContextRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        if (!environment.getPropertySources().contains(BOOTSTRAP_PROPERTY_SOURCE_NAME)) {
            SpringContext.setContext(context);
        }
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void started(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void running(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void failed(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {

    }
}
