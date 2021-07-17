package com.java.corelibrary02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: java5 开始增加的新接口 仅熟悉 有返回值支持泛型
 */

public class $39_ThreadCallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        //计算1~10000之间的累加和并打即返回
        int sum = 0;
        for (int i = 1; i <=1000; i++) {
            sum+=i;
        }
        System.out.println("计算的累加和是："+sum);
        return sum;
    }

    public static void main(String[] args) {
        $39_ThreadCallableTest tct = new $39_ThreadCallableTest();
        FutureTask ft = new FutureTask(tct);
        Thread t1 = new Thread(ft);
        t1.start();
        Object obj = null;
        try {
            obj = ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程处理方法的返回值是："+obj);
    }
}