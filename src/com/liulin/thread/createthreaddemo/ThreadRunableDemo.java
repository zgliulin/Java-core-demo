package com.liulin.thread.createthreaddemo;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadRunableDemo implements  Runnable {
    @Override
    public void run() {
        System.out.println("当前线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadRunableDemo t = new ThreadRunableDemo();
        Thread t1 = new Thread(t);
        t1.start();
    }
}
