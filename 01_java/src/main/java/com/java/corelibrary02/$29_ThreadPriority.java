package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description:
 */

public class $29_ThreadPriority extends Thread{
    @Override
    public void run() {
        System.out.println("子线程的优先级是："+getPriority());
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程优先级： " + i);
        }
    }

    public static void main(String[] args) {
        $29_ThreadPriority tp = new $29_ThreadPriority();
        tp.start();

        Thread t1 = Thread.currentThread();
        t1.setPriority(Thread.MAX_PRIORITY); // 优先级越高 不一定先执行 但是机率会更大
        System.out.println("主线程的优先级是："+t1.getPriority());
        for (int i = 0; i < 10; i++) {
            System.out.println("---主线程优先级： " + i);
        }
    }
}