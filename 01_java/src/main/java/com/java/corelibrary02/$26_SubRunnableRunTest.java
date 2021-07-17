package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 *
 * 实际中更推荐Runnable
 */

public class $26_SubRunnableRunTest {
    public static void main(String[] args) {
        //1.创建自定义类型的对象，也就是实现Runnable接口类的对象
        $25_SubRunnableRun s1 = new $25_SubRunnableRun();
        //2.使用该对象作为实参构适Thread类型的对象
        //由源码可知：经过构造方法的调用之后， Thread类中的成员变量target的数值为srr
        Thread t1 = new Thread(s1);
        //3.使用Thread类型的对象调用start方法
        t1.start();
    }

}