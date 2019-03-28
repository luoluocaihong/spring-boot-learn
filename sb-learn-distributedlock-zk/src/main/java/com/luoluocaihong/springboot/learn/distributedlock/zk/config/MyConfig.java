package com.luoluocaihong.springboot.learn.distributedlock.zk.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;

/**
 * Created by xh on 2019/3/27.
 */
@Configuration
public class MyConfig{

    @Bean
    public CuratorFramework curatorFramework() {
        CuratorFramework client =  CuratorFrameworkFactory.newClient("10.45.82.76", new RetryOneTime(100));
        client.start();
        return client;
    }

//    @Bean
//    public ZookeeperMetadataStore ZookeeperMetadataStore() {
//        ZookeeperMetadataStore zookeeperMetadataStore =  new ZookeeperMetadataStore(curatorFramework());
//        //zookeeperMetadataStore.setRoot("/xh-lock");
//        return zookeeperMetadataStore;
//    }

    @Bean
    public LockRegistry zookeeperLockRegistry() throws Exception {
        return new ZookeeperLockRegistry(curatorFramework());
    }
}
