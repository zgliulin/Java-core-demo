package com.liulin.thread;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadDemo1  extends  Thread{
    @Override
    public void run() {
        System.out.println("当前线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo1 t = new ThreadDemo1();
        t.start();
    }
}
