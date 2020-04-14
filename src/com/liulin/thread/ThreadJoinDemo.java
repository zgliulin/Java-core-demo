package com.liulin.thread;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class ThreadJoinDemo {
    public static int x = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000 ; i++) {
                x += 1;
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000 ; i++) {
                x += 1;
            }
        });
        try {
            t1.start();
            //t1.join();
            t2.start();
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(x);
    }
}
