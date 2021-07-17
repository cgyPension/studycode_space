package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description:
 */

public class $31_ThreadDaemon extends Thread {
    @Override
    public void run() {
        // System.out.println(isDaemon() ? "该线程是守护线程" : "该线程不是守护线程");//默认不是守护线程
        // 当子线程不是守护线程时，虽然主线程先结束了，但是子线程依然会继续执行，直到打印完毕所有数据为止
        // 当子线程是守护线程时，当主线程结束后，则子线程随之结束
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程中i:" + i);
        }
    }

    public static void main(String[] args) {
        $31_ThreadDaemon td = new $31_ThreadDaemon();
        // 必须在线程启动前
        td.setDaemon(true);
        td.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("---------主线程中："+i);
        }
    }
}