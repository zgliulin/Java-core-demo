package com.liulin.thread;

import sun.misc.Cache;

import java.util.concurrent.*;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadCallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("当前线程："+Thread.currentThread().getName());
        return "线程："+Thread.currentThread().getName()+"执行成功";
    }

    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(1);
            Future<String> submit = service.submit(new ThreadCallableDemo());
            System.out.println(submit.get());
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("执行完成");
        }
    }
}
