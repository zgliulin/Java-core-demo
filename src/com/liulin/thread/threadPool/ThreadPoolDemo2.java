package com.liulin.thread.threadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/19 0019
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(() -> {
            System.out.println(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName());
        }, 0, 3000, TimeUnit.MILLISECONDS);
    }


}
