package com.java.corelibrary02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $28_ThreadSleep extends Thread{
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            LocalDateTime todayDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(dtf.format(todayDateTime));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
        $28_ThreadSleep t1 = new $28_ThreadSleep();
        t1.start();

        // 主线程5秒后结束子线程
        System.out.println("主线程开始等待。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // t1.stop(); //已过时
        t1.flag=false;
    }
}