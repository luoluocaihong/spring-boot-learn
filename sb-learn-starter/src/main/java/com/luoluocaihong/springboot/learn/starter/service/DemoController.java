package com.luoluocaihong.springboot.learn.starter.service;

import com.luoluocaihong.springboot.learn.starter.config.HelloConfig;
import com.luoluocaihong.springboot.learn.starter.util.SpringContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xh on 2019/2/22.
 */
@RestController
public class DemoController {

    @GetMapping("/demo/appid")
    public String getAppId() {
        return SpringContext.getContext().getId();
    }


    @GetMapping("/demo/beanname")
    public String getBeanName() {
        return SpringContext.getBean(HelloConfig.class).getClass().getName();
    }
}