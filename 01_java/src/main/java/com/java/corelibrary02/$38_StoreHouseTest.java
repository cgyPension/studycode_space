package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description:
 */

public class $38_StoreHouseTest {
    public static void main(String[] args) {
        // 创建仓库类对象
        $36_StoreHouse storeHouse = new $36_StoreHouse();
        // 创建线程类对象并启动
        $35_ProduceThread p1 = new $35_ProduceThread(storeHouse);
        $37_ConsumerThread c1 = new $37_ConsumerThread(storeHouse);
        p1.start();
        c1.start();
    }

}