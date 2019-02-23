package com.luoluocaihong.springboot.learn.starter.aware;

import com.luoluocaihong.springboot.learn.starter.util.SpringContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by xh on 2019/2/22.
 */
public class SpringContextAware implements ApplicationContextAware{
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.setContext(applicationContext);
    }
}
