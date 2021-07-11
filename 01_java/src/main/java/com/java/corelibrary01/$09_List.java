package com.java.corelibrary01;

import java.util.*;

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

        lt1.add("two");
        lt1.add("3");

        System.out.println("lt1 = " + lt1);
        String it1 = (String) lt1.set(2, "three");
        System.out.println("被修改的元素是：" + it1);
        System.out.println("被修改后集合中的元素是：" + lt1);

        // 使用remove方法将集合中的所有元素删除
       /* for (int i = 0; i < lt1.size();) {
            // 删除元素后 后面的元素补位
            System.out.println("被删除的元素是： " + lt1.remove(0));
        }*/

        // 获取当集合中的子集 也就是将集合中的一部分内容获取出来 子集合和当前集合共用同一块内存空间
        // 表示当前集合lt1中下标从1开始到3之间的元素，左闭右开 包含1但不包含3
        List lt3 = lt1.subList(1, 3);
        System.out.println("lt3 = " + lt3);


        System.out.println("--------------------------------Stack-----------------------------------");
        // TODO 栈 后进先出
        Stack s1 = new Stack();

        // 将数据11 22 33 44 55依次入栈并打印
        for (int i = 1; i <= 5; i++) {
            Object obj = s1.push(i * 11);
            System.out.println("栈中的元素有： " + s1);
        }

        Object obj2 = s1.peek();
        System.out.println("获取到的栈定元素是： " + obj2); // 55

        // 对栈中所有元素依次出栈并打印
        int len = s1.size(); // 只获取一次
        for (int i = 1; i <=len; i++) {
            System.out.println("出栈的元素是： " + s1.pop()); // 55 44 33 22 11
        }


        System.out.println("-------------------------------- queue 接口 -----------------------------------");
        // 队列 先进先出
        Queue queue = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            queue.offer(i*11);
            System.out.println("队列中的元素有： " + queue);
        }

        System.out.println("队首元素是：" + queue.peek());

        int len1 = queue.size();
        for (int i = 1; i <= len1; i++) {
            System.out.println("出队的元素是：" + queue.poll());
        }

        System.out.println("队列中的元素有：" + queue);

        System.out.println("--------------------------------Vectore 已经过时了-----------------------------------");

    }

}