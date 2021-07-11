package com.java.corelibrary01;

import java.util.LinkedList;

/**
 * @author GyuanYuan Cai
 * 2021/7/10
 * Description:
 */

public class $10_ListGeneric {
    public static void main(String[] args) {
        // 支持泛型机制的List集合 明确要求集合中的元素是String
        LinkedList<String> lt1 = new LinkedList<>();
        lt1.add("one");
        String s1 = lt1.get(0);
        System.out.println("获取到的元素是：" + s1);

        System.out.println("-------------------------------------------------------------------");
        // 泛型只在编译期间有效的 在运行时期不区分是什么类型
        // Java7 开始的新特性： 菱形特性  就是后面<> 中的数据类型可以省略
        LinkedList<Double> lt2 = new LinkedList<>();
    }

}