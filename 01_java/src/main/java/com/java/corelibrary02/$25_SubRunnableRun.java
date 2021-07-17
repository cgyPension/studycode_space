package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $25_SubRunnableRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=20; i++) {
            System.out.println("run方法中的i： " + i);
        }
    }

}