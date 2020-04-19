package com.liulin.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Create by DbL on 2020/4/19 0019
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 当前可获得的最大许可数是5个
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i <10 ; i++) {
            new Thread(new Car(i,semaphore)).start();
        }
    }

    static  class Car extends  Thread{
        private int num ;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();  // 获得一个许可
                System.out.println("第"+num+"占用一个停车位");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("第"+num+"辆车走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
