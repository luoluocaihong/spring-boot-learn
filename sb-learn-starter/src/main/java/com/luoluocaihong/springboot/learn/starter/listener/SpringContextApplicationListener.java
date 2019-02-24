package com.luoluocaihong.springboot.learn.starter.listener;

import com.luoluocaihong.springboot.learn.starter.util.SpringContext;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * Created by xh on 2019/2/22.
 */
public class SpringContextApplicationListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        SpringContext.setContext(((ApplicationPreparedEvent)event).getApplicationContext());
    }
}
