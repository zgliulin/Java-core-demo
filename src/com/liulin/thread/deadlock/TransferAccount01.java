package com.liulin.thread.deadlock;

/**
 * Create by DbL on 2020/4/21 0021
 */
public class TransferAccount01 implements  Runnable{
    private Account fromAccount; // 转入账户
    private Account toAccount; // 转出账户
    private int amount;
    Allocator allocator;

    public TransferAccount01(Account fromAccount, Account toAccount, int amount,Allocator allocator) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator = allocator;
    }

    @Override
    public void run() {
        while(true){
            if(allocator.apply(fromAccount,toAccount)){ // 都会在这个地方去获取资源
                try {
                    synchronized (fromAccount) {
                        synchronized (toAccount) {
                            if (fromAccount.getBalance() >= amount) {
                                fromAccount.debit(amount);
                                toAccount.cribit(amount);
                            }
                        }
                        System.out.println(fromAccount.getAccountName() + "--------------" + fromAccount.getBalance());
                        System.out.println(toAccount.getAccountName() + "--------------" + toAccount.getBalance());
                    }
                }finally {
                    allocator.free(fromAccount,toAccount);
                }
            }
        }
    }
}
