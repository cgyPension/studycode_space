package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $23_Thread {
    public static void main(String[] args) {
        //1.使用无参方式构造Thread类型的对象
        // 由源码可知: Thread类中的成员变量target的数值为null
        Thread t1 = new Thread();
        // 2.调用run方法进行测试
        // 由源码可知：由于成员变量target的数值为null,因此条件if (target /= nulL)不成立，跳过行中的代码不执行
        // 而run方法中除了上述代码再无代码，因此证明run方法确实啥也不干
        t1.run();
        System.out.println("hello");

        $24_SubThreadRun t2 = new $24_SubThreadRun();
        // t2.run(); // 这样调用 本质上就是普通成员方法的调用 因此执行流程就是run方法的代码执行完毕后才能继续向下执行
        // 用于启动线程, Java虚拟机会自动调用该类线程类中的run方法
        t2.start();

        // 相当于又启动了一个线程，加上执行main方法的线程是两个线程
        for (int i = 0; i <=20; i++) {
            System.out.println("--------main方法中的i： " + i);
        }

        System.out.println("-----------------------------------------------");
        // 匿名内部类实现
        Thread t3 = new Thread("a") {
            @Override
            public void run() {
                System.out.println("Jane 在吗？");
                System.out.println ("子线程的编号是: "+ getId() + ",名称是:" + getName());
            }
        };
        t3.start();

     /*   Runnable ra = new Runnable() {
            @Override
            public void run() {
                System.out.println("在");
            }
        };
        Thread t4 = new Thread(ra);
        t4.start();*/
/*        Runnable ra = () -> System.out.println("在");
        new Thread(ra).start();*/
        new Thread(() -> System.out.println("在")).start();
    }

}