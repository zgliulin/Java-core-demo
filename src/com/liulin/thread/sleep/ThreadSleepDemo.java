package com.liulin.thread.sleep;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadSleepDemo  extends Thread{
    public static void main(String[] args) {
        new ThreadSleepDemo().start();
    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(3000);
            System.out.println(System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
