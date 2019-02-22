package com.luoluocaihong.springboot.learn.starter.util;

import org.springframework.context.ApplicationContext;

/**
 * Created by xh on 2019/2/22.
 */
public abstract class SpringContext {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        SpringContext.context = context;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return getContext().getBean(beanClass);
    }
}
