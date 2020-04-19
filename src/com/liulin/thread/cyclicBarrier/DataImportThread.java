package com.liulin.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Create by DbL on 2020/4/19 0019
 */
public class DataImportThread extends Thread {
    private String path;

    private CyclicBarrier cyclicBarrier;

    public DataImportThread(String path, CyclicBarrier cyclicBarrier) {
        this.path = path;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        System.out.println("开始导入:"+path+"位置的数据");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
