package com.liulin.thread.deadlock;

/**
 * Create by DbL on 2020/4/21 0021
 */
public class TransferAccount implements  Runnable{
    private Account fromAccount; // 转入账户
    private Account toAccount; // 转出账户
    private int amount;

    public TransferAccount(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        while(true){
            synchronized (fromAccount){
                synchronized (toAccount){
                    if(fromAccount.getBalance()>=amount){
                        fromAccount.debit(amount);
                        toAccount.cribit(amount);
                    }
                }
                System.out.println(fromAccount.getAccountName()+"--------------"+fromAccount.getBalance());
                System.out.println(toAccount.getAccountName()+"--------------"+toAccount.getBalance());
            }
        }
    }
}
