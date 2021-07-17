package com.java.corelibrary02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description:
 */

public class $40_ThreadPool {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 向线程池中布置任务
        executorService.submit(new $39_ThreadCallableTest());
        // 关闭线程池
        executorService.shutdown();
    }

}