package com.liulin.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/15 0015
 */
public class ThreadInterruptDemo2 {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while(true){
                //true标识被中断过
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 对中断标识复位 false
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); //中断
    }
}
