package com.liulin.thread.forkjoin;

import javax.swing.text.EditorKit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Create by DbL on 2020/4/21 0021
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {
    //计算1...10的累加
    // 每个任务的大小2
    private final int THREHOLD = 2;
    private int start;
    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THREHOLD;
        if (canCompute) {// 不能分割
            // 输出看进行了多少次分割任务
            System.out.println("start:"+start+"-end:"+end);
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            left.fork();
            right.fork();
            int leftResult = left.join();
            int rightResult = right.join();
            // 类似于递归，不同的是每个子任务是通过线程去处理的
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1,10);
        ForkJoinTask<Integer> result = forkJoinPool.submit(forkJoinDemo);
        System.out.println("result:"+result.get());
    }
}
