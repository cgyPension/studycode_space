package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/15
 * Description: 生产者 不断生产产品
 */

public class $35_ProduceThread extends Thread{
    // 声明一个仓库类型的引用作为成员变量，是为了能调用调用仓库类中的生产方法合成复用原则
    private $36_StoreHouse storeHouse;
    // 为了确保两个线程共用同一个仓库

    public $35_ProduceThread($36_StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {
        while (true) {
            storeHouse.produceProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}