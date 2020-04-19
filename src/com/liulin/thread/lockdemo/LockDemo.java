package com.liulin.thread.lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by DbL on 2020/4/16 0016
 */
public class LockDemo {
    static Lock lock = new ReentrantLock();
    public static int count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(LockDemo::incr).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static void decr(){
        lock.lock();
        count--;
        lock.unlock();
    }
    public static void incr(){
        try{
            lock.lock();
            decr();
            count++;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
