package com.liulin.thread.deadlock;

/**
 * Create by DbL on 2020/4/21 0021
 */
public class Account {
    private String accountName;
    private int balance;

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public void debit(int amount) {
        this.balance -= amount;
    }

    public void cribit(int amount) {
        this.balance += amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
