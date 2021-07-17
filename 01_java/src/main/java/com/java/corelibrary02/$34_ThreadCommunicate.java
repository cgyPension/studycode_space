package com.java.corelibrary02;

public class $34_ThreadCommunicate implements Runnable{
    private int cnt = 1;


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //每当有一个线程进来后先大赋一声，调用notify方法
                notify();
                if (cnt <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + "中: cnt ="+ cnt);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    //当前线程打印完毕一个整数后，为了防止继续打印下一个数据,则调用wait方法
                    try {
                        wait(); // 当前线程进入阻塞状态,自动释放对象锁,必须在锁定的代码中调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        $34_ThreadCommunicate tt = new $34_ThreadCommunicate();

        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);

        t1.start();
        t2.start();
    }
}
