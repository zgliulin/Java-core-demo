package com.liulin.thread.bagdemo;

import com.liulin.thread.bagdemo.ThreadConsumer;
import com.liulin.thread.bagdemo.ThreadProducer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by DbL on 2020/4/15 0015
 */
public class TestBags {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int size =10;

        ThreadProducer producer = new ThreadProducer(queue,size);
        ThreadConsumer consumer = new ThreadConsumer(queue,size);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
