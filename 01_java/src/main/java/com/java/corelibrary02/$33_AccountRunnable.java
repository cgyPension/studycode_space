package com.java.corelibrary02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description:
 */

public class $33_AccountRunnable extends Thread{
    private int balance; // 银行账户

    private ReentrantLock lock = new ReentrantLock(); // lock

    public $33_AccountRunnable() {
    }

    public $33_AccountRunnable(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public /*synchronized*/ void run() {
            System.out.println ("线程" + Thread.currentThread().getName () +"已启动...");
            // lock.lock();  // 手动上锁
        // synchronized (Thread.class) {
       // synchronized ("A") {
        //由源码可知：最终是account对象来调用run方法，因此当前正在调用的对象就是account，也就是说this就是account
        synchronized (this) { // 锁 自动上锁 自动解锁
            // 模拟从后台查询账户余额的过程
            int temp = getBalance();
            // 模拟取款200元的过程
            if (temp >= 200) {
                System.out.println("正在出钞 请稍后...");
                temp -= 200;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请取走你的钞票");
            } else {
                System.out.println("余额不足 请核对您的账户余额！");
            }
            // 模拟最新的账户余额写入到后台
            setBalance(temp);
        }

        // lock.unlock();  // 手动解锁
    }

    public static void main(String[] args) {
        $33_AccountRunnable account = new $33_AccountRunnable(1000);
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);

        t1.start();
        t2.start();

        System.out.println("主线程开始等待");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待结束");
        System.out.println("账户余额：" + account.getBalance());
    }
}