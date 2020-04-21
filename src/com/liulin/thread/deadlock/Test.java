package com.liulin.thread.deadlock;

/**
 * Create by DbL on 2020/4/21 0021
 */
public class Test {
    public static void main(String[] args) {
        Account fromAccount = new Account("zhangsan",100000);
        Account toAccount = new Account("lisi",200000);

        /*Thread a = new Thread(new TransferAccount(fromAccount,toAccount,1));
        Thread b = new Thread(new TransferAccount(toAccount,fromAccount,1));*/
        /*Allocator allocator = new Allocator(); // 统一分配锁
        Thread a = new Thread(new TransferAccount01(fromAccount,toAccount,1,allocator));
        Thread b = new Thread(new TransferAccount01(toAccount,fromAccount,1,allocator));*/
        Thread a = new Thread(new TransferAccount03(fromAccount,toAccount,1));
        Thread b = new Thread(new TransferAccount03(toAccount,fromAccount,1));

        a.start();
        b.start();
    }
}
