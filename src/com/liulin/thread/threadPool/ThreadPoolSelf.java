package com.liulin.thread.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/20 0020
 */
public class ThreadPoolSelf extends ThreadPoolExecutor {

    public ThreadPoolSelf(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        // 任务执行开始会执行这个方法
        // TODO
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("初始线程数："+this.getPoolSize());
        System.out.println("核心线程数："+this.getCorePoolSize());
        System.out.println("正在执行的任务数量："+this.getActiveCount());
        System.out.println("已经执行的任务数："+this.getCompletedTaskCount());
        System.out.println("任务总数："+this.getTaskCount());
    }
}
