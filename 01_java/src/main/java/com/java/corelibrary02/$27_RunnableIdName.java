package com.java.corelibrary02;
/**
* @author GyuanYuan Cai
* 2021/7/14
* Description:
*/

public class $27_RunnableIdName implements Runnable{
    @Override
    public void run() {
        // 获取当前正在执行线程的引用 也就是子线程的引用
        Thread t1 = Thread.currentThread();
        System.out.println ("子线程的编号是: "+ t1.getId() + ",名称是:" + t1.getName());
    }

    public static void main(String[] args) {
        $27_RunnableIdName rint = new $27_RunnableIdName();
        Thread t2 = new Thread(rint,"财神");
        t2.start();

        // 获取当前正在执行线程的引用 当前正在执行的线程是主线程 也就是获取主线程的引用
        Thread t1 = Thread.currentThread();
        System.out.println ("子线程的编号是: "+ t1.getId() + ",名称是:" + t1.getName());
    }
}