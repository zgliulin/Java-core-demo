package com.liulin.thread.bagdemo;

import java.util.Queue;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadProducer implements Runnable{
    private Queue<String> bags;
    int size;

    public ThreadProducer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (bags) {
                while (size == bags.size()) {
                    System.out.println("背包满了");
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
                bags.add("bag" + i);
                System.out.println("生产者生产：" + i);
                bags.notifyAll();
            }
        }
    }
}
