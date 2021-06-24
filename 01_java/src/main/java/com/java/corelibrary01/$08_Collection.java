package com.java.corelibrary01;

import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.java.corelibrary01.lagou.manageStudent.Student;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.apache.commons.lang3.StringUtils;

/**
 * @author GyuanYuan Cai
 * 2021/6/22
 * Description:
 */

public class $08_Collection {
    public static void main(String[] args) {
        // Collection 是接口不能直接实例化 可以引用指向实现类的对象 形成多态
        Collection c1 = new ArrayList();
        System.out.println("集合中的元素有：" + c1); // []

        c1.add("one");
        c1.add(1);
        c1.add(new Student(1, "你好", 23)); // [one, 1, Student [id=1, name=你好, age=23]] 格式是因为Student重写了toString
        System.out.println("集合中的元素有：" + c1);

        System.out.println("----------------------add-----------------------------");
        Collection c2 = new ArrayList();
        c2.add("three");
        c2.add(3);
        c1.addAll(c2); // 将c2所有元素添加到c1中
        System.out.println("集合中的元素有：" + c1); // [one, 1, Student [id=1, name=你好, age=23], three, 3]
        c1.add(c2); // 将c2整体看做一个元素添加到机车c1中
        System.out.println("集合中的元素有：" + c1); // [one, 1, Student [id=1, name=你好, age=23], three, 3, [three, 3]]

        System.out.println("-----------------------contains----------------------------");
        System.out.println("c1中是否存在 “one”：" + c1.contains("one")); // true
        // contains的工作原理 判断的是Objects.equals(o,e)方法
        /*
        public static boolean equals(object a, object b) {
        return (a == b) || (a!= null && a.equals(b));
        } //其中代表Person对象,b代表集合中已有的对象
         */
        // 若是没有重写equals方法，测调用从Object继承下来的equals方法 比较的是两个对象的地址
        System.out.println("c1中是否存在 student对象：" + c1.contains(new Student(1, "你好", 23))); // true

        System.out.println("判断当前集合是否包含指定集合的所有元素： " + c1.containsAll(c2)); // true
        System.out.println("判断当前集合是否包含指定集合的整体元素： " + c1.contains(c2)); // true

        System.out.println("-------------------------交集--------------------------");
        // 让集合自己和自己交集 还是自己 也就是当前集合中的元素没有发生改变
        System.out.println("交集： " + c2.retainAll(c2));// false
        System.out.println("交集： " + c1.retainAll(c2));// true
        System.out.println("c1 = " + c1);

        System.out.println("-------------------------删除--------------------------");
        c1.remove(3); // 删除单个元素
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        c1.add(3);
        c1.removeAll(c2); // 删除c1 c2集合中的所有元素
        System.out.println("c1 = " + c1);

        System.out.println("----------------------------------集合是否相等-----------------");
        System.out.println("集合中元素的个数为： " + c2.size());
        c2.clear(); // 清空集合
        System.out.println(c2.isEmpty() ? "空" : "不空");

        Collection c3 = new ArrayList();
        Collection c4 = new ArrayList();

        c3.add(1);
        c3.add(2);

        c4.add(1);
        c4.add(2);

        System.out.println(c3.equals(c4));// true 判断两个集合是否相等

        System.out.println("------------------------------集合数组互换---------------------");
        // 实现集合和数组之间的转换 通常认为：集合是用于取代数组的结构
        Object[] objects = c4.toArray();
        System.out.println("数组中的元素有：" + Arrays.toString(objects));
        // 实现数组类型到集合
        Collection objects1 = Arrays.asList(objects);
        System.out.println("集合中的元素有：" + objects1);

        System.out.println("------------------------------集合迭代器---------------------");
        // 集合迭代器遍历所有元素
        Iterator iterator1 = c4.iterator();
        System.out.println("判断是否有元素可以访问： " + iterator1.hasNext());
/*        while (iterator1.hasNext()) {
            System.out.println("获取到的元素是："+iterator1.next());
        }*/

        // 模拟toString
        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            if (!iterator1.hasNext()) {
                sb1.append(obj).append("]");
            } else {
                sb1.append(obj).append(",").append(" ");
            }
        }
        System.out.println("sb1 = " + sb1);


        Iterator iterator2 = c3.iterator();
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            if ("one".equals(obj)) {
                c3.remove(obj);
            }
        }
        System.out.println("删除集合后的元素："+c3);

        System.out.println("------------------------------foreach---------------------");
        // 用来调试debug挺好的 由源码可知foreach是迭代器的简化版
        for (Object o : c3) {
            System.out.println("增强型for循环： " + o);
        }

        System.out.println("------------------------------Set---------------------");
        Set<String> set1 = new HashSet<>();




    }

}