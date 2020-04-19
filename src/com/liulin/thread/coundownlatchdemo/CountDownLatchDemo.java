package com.liulin.thread.coundownlatchdemo;

import java.util.concurrent.CountDownLatch;

/**
 * Create by DbL on 2020/4/18 0018
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()->{
           countDownLatch.countDown();
        });
        new Thread(()->{
            countDownLatch.countDown();
        });
       /* new Thread(()->{
            countDownLatch.countDown();
        });*/
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完毕");
    }

}
