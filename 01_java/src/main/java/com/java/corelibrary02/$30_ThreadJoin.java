package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description:
 */

public class $30_ThreadJoin extends Thread{
    @Override
    public void run() {
        System.out.println("倒计时开始！");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("新年快乐！！！");
    }

    public static void main(String[] args) {
        $30_ThreadJoin t1 = new $30_ThreadJoin();
        t1.start();

        // 主线程5秒后结束子线程
        System.out.println("主线程开始等待。。。");
        try {
            // t1.join();//表示当前正在执行的线程对象等待调用线程对象，也就是主线程等待子线程终止
            t1.join(5000); // 最多等待5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("终于等到你 还好没放弃！");
    }

}