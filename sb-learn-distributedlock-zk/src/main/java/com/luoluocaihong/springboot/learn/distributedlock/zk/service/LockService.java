package com.luoluocaihong.springboot.learn.distributedlock.zk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;

/**
 * Created by xh on 2019/3/27.
 */
@RestController
public class LockService {
    @Autowired
    private LockRegistry lockRegistry;

    private volatile boolean lockThreadA;
    private volatile boolean lockThreadB;

    @GetMapping("/lock")
    public String getLock() {

        lockThreadA = false;
        lockThreadB = false;

        //创建2个线程争抢锁
        Thread threadA = new Thread(() -> {
            Lock lock = lockRegistry.obtain("lock-xh");
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " get lock");
                lockThreadA = true;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            Lock lock = lockRegistry.obtain("lock-xh");
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " get lock");
                lockThreadB = true;
                try {
                    //休眠一下  只是想通过zkCli看看zk 创建的临时节点
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });

        threadA.setName("ThreadA");
        threadB.setName("ThreadB");
        //先启动线程B 再启动线程A
        threadB.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();

        try {
            threadB.join();
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StringBuilder returnStr = new StringBuilder();
        returnStr.append("Hello luoluocaihong.Here is your test result:");
        if (lockThreadA) {
            returnStr.append("ThreadA get lock.");
        }
        if (lockThreadB) {
            returnStr.append("ThreadB get lock.");
        }
        return returnStr.toString();
    }
}
