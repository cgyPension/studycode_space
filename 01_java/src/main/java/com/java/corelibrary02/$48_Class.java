package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: 反射
 * java.lang.Class类的实例可以用于描述Java应用程序中的类和接口,也就是一种数据类型。
 * 该类没有公共构造方法,该类的实例由lava虚拟机和类加载器自动构造完成,本质上就是加载到内存中的运行"时类。
 */

public class $48_Class {
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO 方式一 四 最常用
        // 方式一：使用数据类型.class的方式可以获取对应类型的CLass对象
        Class c1 = String.class;
        System.out.println("c1 = " + c1); // 自动调用tostring方法class java.Lang.String

        // 方式二：使用对象.getclass()的方式获取对应的CLass对象
        String str1 = new String("hello");
        c1 = str1.getClass();
        System.out.println("c1 = " + c1);

        int num = 5;
        //num.getcLass(); Error:基本数据类型的变量不能调用方法 不是对象

        // 方式三：使用包装类.TYPE的方式来获取对应基本数据类型的CLass对象
        c1 = Integer.TYPE;
        System.out.println("c1 = " + c1);
        c1 = Integer.class;
        System.out.println("c1 = " + c1);

        // 方式四：调用CLass类中的forName方法来获取对应的CLass对象
        c1 = Class.forName ("java.lang.String");
        System.out.println("c1 = " + c1);

        // 方式五：使用类加载器的方式来获取CLass对象
       // ClassLoader classLoader = String.class.getClassLoader(); // null
        ClassLoader classLoader = $48_Class.class.getClassLoader();
        c1 = classLoader.loadClass("java.lang.String");
        System.out.println("c1 = " + c1);
    }

}