package com.liulin.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Create by DbL on 2020/4/19 0019
 */
public class CyclicBarrierDemo extends  Thread{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =new CyclicBarrier(3,new CyclicBarrierDemo());

        new DataImportThread("path1",cyclicBarrier).start();
        new DataImportThread("path2",cyclicBarrier).start();
        new DataImportThread("path3",cyclicBarrier).start();
        // TODO 希望三个线程执行结束之后，再做一个汇总处理

    }

    @Override
    public void run() {
        System.out.println("开始进行数据汇总和分析");
    }
}
