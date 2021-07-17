package com.java.corelibrary02;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: 反射
 */

public class $49_PersonConstructor {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {
        $07_Person p1 = new $07_Person();
        System.out.println("无参方式创建的对象是：" + p1);

        System.out.println("------------------------------------------------------");
        // 使用反射机制以无参形式构造Person类型的对象并打印 动态输入 也可以从配置文件读取
/*        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/a.txt")));
        String str1 = br.readLine();
        Class c1 = Class.forName(str1);*/
        Class c1 = Class.forName("com.java.corelibrary02.$07_Person");
       // System.out.println("无参方式创建的对象是：" + c1.newInstance()); // 过时不建议使用
        Constructor constructor = c1.getConstructor();
        System.out.println("无参方式创建的对象是：" + constructor.newInstance());


        System.out.println("-------------------------- 有参方式 ---------------------------");
        $07_Person p2 = new $07_Person("jane",18);
        System.out.println("无参方式创建的对象是：" + p2);
        // newInstance方法中的实参是用于给有参构造方法的形参进行初始化的,也就是给name和age进行初始化的
        Constructor constructor1 = c1.getConstructor(String.class, int.class);
        System.out.println("有参方式创建的对象是：" + constructor1.newInstance("linyan",18));

       // 使用反射机制获取Person类中所有的公共构造方法并打印
        Constructor[] constructors = c1.getConstructors();
        for (Constructor ct : constructors) {
            System.out.println("构造方法的访问修饰符是：" + ct.getModifiers());
            System.out.println("构造方法的方法名称是：" + ct.getName());
            Class[] parameterTypes = ct.getParameterTypes();
            System.out.println("构造方法的所有参数类型是：");
            for (Class cs : parameterTypes) {
                System.out.println(cs);
            }
            System.out.println();
        }


    }

}