package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description: 生产仓库
 */

public class $36_StoreHouse {
    private int cnt = 0;// 用于记录产品的数量


    public synchronized void produceProduct() {
        notify();
        if (cnt < 10) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在生产第" + (cnt + 1) + "个产品...");
            cnt++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        notify();
        if (cnt > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在消费第" + cnt + "个产品...");
            cnt--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}