package com.java.corelibrary01;

/**
 * @author GyuanYuan Cai
 * 2021/7/10
 * Description:
 */

public class $12_PersonTest {
    public static void main(String[] args) {
        $11_Person p1 = new $11_Person("zhangsan", 30, "男");
        System.out.println(p1);

        System.out.println("-------------------------------------------------------------------");
        // 在创建对象的同时制定数据类型 用于给T进行初始化
        $11_Person<String> p2 = new $11_Person<>();
        p2.setGender("女");
        System.out.println(p2);

        // 调用泛型方法进行测试
        Integer[] arr = {11,22,33,44,55};
        $11_Person.printArray(arr);
    }

}