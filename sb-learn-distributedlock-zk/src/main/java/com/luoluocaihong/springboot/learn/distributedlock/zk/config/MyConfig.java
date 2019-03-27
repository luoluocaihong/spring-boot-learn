package com.luoluocaihong.springboot.learn.distributedlock.zk.config;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.utils.DefaultZookeeperFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;
import org.springframework.integration.zookeeper.metadata.ZookeeperMetadataStore;

/**
 * Created by xh on 2019/3/27.
 */
@Configuration
public class MyConfig{

//    @Bean
//    public CuratorZookeeperClient curatorZookeeperClient() {
//        return new CuratorZookeeperClient("172.16.22.2;2182", 500,500, this, new RetryOneTime(100));
//    }

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
    public ZookeeperLockRegistry zookeeperLockRegistry() throws Exception {
        return new ZookeeperLockRegistry(curatorFramework());
    }
}
