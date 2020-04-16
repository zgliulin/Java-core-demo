package com.liulin.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/15 0015
 */
public class ThreadStopDemo {
    static volatile boolean stop = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(new StopThread());
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = false;
    }

    static class StopThread implements Runnable {

        @Override
        public void run() {
            while (stop) {
                System.out.println("持续运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
