package com.liulin.thread.coundownlatchdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/18 0018
 */
public class App implements Runnable{
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public  static int j = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new App()).start();
        }
        countDownLatch.countDown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("最终的值："+j);
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+"此时j的值为："+j);
            j++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
