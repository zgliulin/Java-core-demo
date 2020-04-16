package com.liulin.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/15 0015
 */
public class ThreadInterruputDemo {

    static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(i++);
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
