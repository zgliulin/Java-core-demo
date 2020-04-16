package com.liulin.thread.bagdemo;

import java.util.Queue;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadConsumer implements Runnable{
    private Queue<String> bags;
    int size;

    public ThreadConsumer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bags) {
                while (bags.isEmpty()) {
                    System.out.println("背包为空");
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费：" + bags.remove());
                bags.notifyAll();
            }
        }
    }
}
