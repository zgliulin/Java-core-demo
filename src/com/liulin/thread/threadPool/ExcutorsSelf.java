package com.liulin.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/20 0020
 */
public class ExcutorsSelf {
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolSelf(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


    }
}
