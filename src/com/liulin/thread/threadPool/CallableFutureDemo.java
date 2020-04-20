package com.liulin.thread.threadPool;

import java.util.concurrent.*;

/**
 * Create by DbL on 2020/4/20 0020
 */
public class CallableFutureDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("hello DBL");
        return "DBL";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*CallableFutureDemo callableFutureDemo = new CallableFutureDemo();
        FutureTask futureTask = new FutureTask(callableFutureDemo);
        new Thread(futureTask).start();
        // 线程执行完成后可以通过get方法获取到线程的返回值，get方法时属于阻塞方法
        System.out.println(futureTask.get());*/
        CallableFutureDemo callableFutureDemo = new CallableFutureDemo();
        ExecutorService service = Executors.newFixedThreadPool(1);
        FutureTask future = (FutureTask) service.submit(callableFutureDemo);
        System.out.println(future.get());

    }
}
