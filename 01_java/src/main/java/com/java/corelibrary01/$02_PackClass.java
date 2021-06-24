package com.java.corelibrary01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * @author GyuanYuan Cai
 * 2021/6/18
 * Description:
 */

public class $02_PackClass {

    /*
    通常情况下基本数据类型的变量不是对象,为了满足万物皆对象的理念就需要对基本数据类型的变量进行打包封装处理变成对象,
    而负责将这些变量声明为成员变量进行对象化处理的相关类,叫做包装类。
    八种
     */
    public static void main(String[] args) {
        // 打印Integer类中常用的常量数值
        System.out.println("最大值是：" + Integer.MAX_VALUE); // 2147483647
        System.out.println("最小值是： " + Integer.MIN_VALUE); // -2147483648
        System.out.println("Integer.SIZE = " + Integer.SIZE); // 32
        System.out.println("Integer.BYTES = " + Integer.BYTES); // 4
        System.out.println("Integer.TYPE = " + Integer.TYPE); // int

        System.out.println("最大值是：" + Long.MAX_VALUE); // 2147483647
        System.out.println("最小值是： " + Long.MIN_VALUE); // -2147483648

        System.out.println("------------------------------------Integer--------------------------------------");

        // 从int类型到integer的转换
        Integer it1 = Integer.valueOf(123);
        // 从String类型到integer的转换
        Integer it2 = Integer.valueOf("456");
        // int it3 = Integer.valueOf("456");
        // 调用对象中的整数数值，相当于从integer类型到int类型的转换
        int i1 = it2.intValue();

        System.out.println("-----------------------------------------------------------------------------------");
        // 从java5开始 增加了自动装箱和自动拆箱的机制
        Integer it5 = 100; // 自动通过赋值运算符实现自动装箱
        int i2 = it5; // 自动通过赋值运算符实现自动拆箱

        System.out.println("-----------------------------------------------------------------------------------");
        // 静态方法的调用
        int i3 = Integer.parseInt("200");

        System.out.println("--------------------------------------Double-----------------------------------------");
        Double D1 = Double.valueOf(3.14);
        double d1 = D1;

        System.out.println("--------------------------------------Boolean-----------------------------------------");
        Boolean B1 = false;
        // 该方法的执行原理是:只要参数数值不为true或者TRUE时,则结果就是false
        boolean b1 = Boolean.parseBoolean("TRUE");

        System.out.println("--------------------------------------Character-----------------------------------------");
        Character a = Character.valueOf('a');

        System.out.println("--------------------------------------BigDecimal-----------------------------------------");
        // BIgInteger 与 BigDecimal相似
        BigDecimal b2 = BigDecimal.valueOf(5.2);
        BigDecimal b3 = BigDecimal.valueOf(1.3);

        System.out.println("加法 " + b2.add(b3));
        System.out.println("减法 " + b2.subtract(b3));
        System.out.println("乘法  " + b2.multiply(b3));
        System.out.println("除法 " + b2.divide(b3));
        System.out.println("除法 向上取整" + b2.divide(b3, RoundingMode.HALF_UP));
        System.out.println("取余 " + b2.remainder(b3));
    }

}