package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: 消费者线程
 */

public class $37_ConsumerThread extends Thread{
    private $36_StoreHouse storeHouse;
    // 为了确保两个线程共用同一个仓库

    public $37_ConsumerThread($36_StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {
        while (true) {
            storeHouse.consumerProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}