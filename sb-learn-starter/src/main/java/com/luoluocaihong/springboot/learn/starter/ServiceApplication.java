package com.luoluocaihong.springboot.learn.starter;

import com.luoluocaihong.springboot.learn.starter.listener.SpringContextApplicationListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by xh on 2019/2/15.
 */
@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
//         //方式一:调用SpringApplication的静态run方法,在该方法中创建SpringApplication对象并调用该对象的run方法.
        //SpringApplication.run(ServiceApplication.class, args);

        //方式二:创建SpringApplication对象,做一些定制化的配置,再调用run方法
        SpringApplication application = new SpringApplication(ServiceApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
//        //添加自定义的Listener  可以在这里配置,也可以在resources\META-INF下的spring.factories中配置listener
//        application.addListeners(new SpringContextApplicationListener());
        application.run(args);

        //打印所有的ApplicationContextInitializer
        System.out.println("==========ApplicationContextInitializer==========");
        application.getInitializers().forEach(initializer -> {
            System.out.println(initializer.getClass().getName());
        });

        //打印所有的ApplicationListener
        System.out.println("==========ApplicationListener==========");
        application.getListeners().forEach(listener -> {
            System.out.println(listener.getClass().getName());
        });
    }
}
