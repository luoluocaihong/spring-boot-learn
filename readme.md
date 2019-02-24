#### sb-learn-starter 
##### Spring容器的注入方式  
方式一,自动注入  
```com.luoluocaihong.springboot.learn.starter.service.DemoController```中```@Autowired private ApplicationContext context;```

方式二,使用spring aware的方式注入spring容器  
通过实现```org.springframework.context.ApplicationContextAware```接口让Bean获得Spring容器的能力  
代码:```com.luoluocaihong.springboot.learn.starter.aware.SpringContextAware```
通过配置```luoluocaihong.spring.context.aware.enabled=true```来启动这种方式  

方式三,使用springboot的事件监听机制,写一个监听器,监听容器prepared事件```ApplicationPreparedEvent```,在监听器中完成spring容器的注入  
代码```com.luoluocaihong.springboot.learn.starter.listener.SpringContextApplicationListener```  
通过在```resources\META-INF\spring.factories```中配置```org.springframework.context.ApplicationListener```的实现类即可  

方式四,同方式三有点类似,只不过选的扩展点不一样,实现```org.springframework.boot.SpringApplicationRunListener```接口,在```contextPrepared```方法中将spring容器的注入  
代码```com.luoluocaihong.springboot.learn.starter.listener.SpringContextRunListener```  
通过在```resources\META-INF\spring.factories```中配置```org.springframework.boot.SpringApplicationRunListener```的实现类即可 