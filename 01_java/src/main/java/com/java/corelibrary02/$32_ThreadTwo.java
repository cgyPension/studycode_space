package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description:
 */

public class $32_ThreadTwo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            // 打印 1~100之间的所有奇数
            for (int i = 1; i <= 100; i += 2) {
                System.out.println("子线程一中：i= " + i);
            }
        });


        Thread t2 = new Thread(() -> {
            // 打印 1~100之间的所有偶数
            for (int i = 2; i <= 100; i += 2) {
                System.out.println("子线程二中：i= " + i);
            }
        });

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

    }

}