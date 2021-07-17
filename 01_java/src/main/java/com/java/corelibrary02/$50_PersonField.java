package com.java.corelibrary02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description:
 */

public class $50_PersonField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        $07_Person p1 = new $07_Person("jane",18);
        System.out.println("获取到的成员变量是：" + p1.getName());

        System.out.println("---------------------------------------------------------");
        Class c1 = Class.forName("com.java.corelibrary02.$07_Person");
        Constructor constructor1 = c1.getConstructor(String.class, int.class);
        Object obj = constructor1.newInstance("linyan", 18);
        // 根据CLass对象获取对应的成员变量信息
        Field field = c1.getDeclaredField("name");
        // 设置Java语言访问检查的取消 暴力访问 可以访问私有属性
        field.setAccessible(true);
        //获取对象object中名字为field成员变量的数值，也就是成员变量name的数值
        System.out.println("获取到的成员变量数值为：" + field.get(obj)); // 私有化成员变量获取不了
        System.out.println("---------------------------------------------------------");

/*        p1.name = "haha";
        System.out.println(p1.name);*/

        // 使用反射机制修改指定对象中成员变量的数值后再次打印
        field.set(obj,"下一个");
        System.out.println("修改后的成员变量数值为：" + field.get(obj));

        //
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field ft : declaredFields) {
            System.out.println("获取到的访问修饰符是：" + ft.getModifiers());
            System.out.println("获取到的数据类型是：" + ft.getType());
            System.out.println("获取到的成员变量名称是：" + ft.getName());
            System.out.println();
        }
    }

}