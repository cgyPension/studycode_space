package com.java.corelibrary01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/6/23
 * Description:
 */

public class $09_List {
    public static void main(String[] args) {
        System.out.println("--------------------------------List-----------------------------------");
        // 形成多态
        // 由源码可知：当new对象时并没有申请数组的内存空间
        List lt1 = new ArrayList();
        // 当调用add方法添加元素时会给数组申请长度为10的一维数组
        // 扩容是原始长度的1.5倍
        lt1.add("one");
        System.out.println("lt1 = " + lt1);
        System.out.println("one 第一次出现的索引位置： " + lt1.indexOf("one"));

        System.out.println("--------------------------------LinkedList-----------------------------------");
        // ArrayList底层采用动态数组 支持下标访问 增删不方便 更适合于访问
        // LinkedList双向链表 访问不方便 增删方便 更适合插入和删除
        List lt2 = new LinkedList();
        lt2.add("one");
        lt2.add(0,"0"); // 向索引为1的位置添加元素
        System.out.println("lt2 = " + lt2);
        System.out.println("获取指定下标的元素： " + lt2.get(1));

        System.out.println("--------------------------------Stack-----------------------------------");
        // 栈 后进先出

        System.out.println("--------------------------------Vectore 已经过时了-----------------------------------");

    }

}