package com.java.corelibrary02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description:
 */

public class $51_PersonMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        $07_Person p1 = new $07_Person("jane", 18);
        System.out.println("获取到的成员变量是：" + p1.getName());

        System.out.println("---------------------------------------------------------");
        Class c1 = Class.forName("com.java.corelibrary02.$07_Person");
        Constructor constructor1 = c1.getConstructor(String.class, int.class);
        Object obj = constructor1.newInstance("linyan", 18);

        // 根据CLass对象来获取对应的成员方法
        Method m1 = c1.getMethod("getName");

        // 使用对象调用成员方法进行打印
        System.out.println("调用方法的返回值是：" + m1.invoke(obj));

        System.out.println("---------------------------------------------------------");
        Method[] methods = c1.getMethods();
        for (Method mt : methods) {
            System.out.println("成员方法的修饰是: " + mt.getModifiers());
            System.out.println("成员方法的返回值类型是:" + mt.getReturnType());
            System.out.println("成员方法的名称是: " + mt.getName());
            System.out.println("成员方法形参列表的类型是:");
            Class<?>[] parameterTypes = mt.getParameterTypes();
            for (Class ct : parameterTypes) {
                System.out.println(ct + " ");
            }
            System.out.println();
            System.out.println("成员方法的异常类型列表是: ");
            Class<?>[] exceptionTypes = mt.getExceptionTypes();
            for (Class ct : exceptionTypes) {
                System.out.print(ct + " ");
            } ;
            System.out.println("---------------------------------------------------------");
        }
    }

}