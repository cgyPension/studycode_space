package com.java.base;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description: 变量 在内存中申请一个存储单元
 */

public class $01_Variable {
    public static void main(String[] args) {
/*
        System.out.println("请输入您的名字和年龄");
        // 创建一个扫描器来扫描键盘的输入内容 System.in代表键盘输入
        Scanner sc = new Scanner(System.in);
        String name = sc.next( );
        int age = sc.nextInt();
        System.out.println("name = " + name);
        System.out.println("age = " + age);
*/

        System.out.println("--------------------------------------------");

        float f1 = 3.1415926f;
        System.out.println("f1 = " + f1); // 1 = 3.1415925; 一般是7位有效数字

        double d1 = 3.1415926;
        System.out.println("d1 = " + d1); // d1 = 3.1415926 一般是15位有效数字

        // 重点
        // 小数点类型 默认为double
        System.out.println(0.1+0.2);  // 0.300000000000000000004 运算时可能有误差
        // 若希望精确计算 则借助java.math.BigDecimal 类型

        System.out.println("--------------------------------------------");
        char c1 = 'a';
        System.out.println("c1 = " + c1);
        System.out.println("对应的ASCii码是 " + (int)c1);

        // JAVA 是使用Unicode字符
        char c2 = '\u5947';
        char c3 = '\u70b9';
        System.out.println("最终的结果是："+c2+c3);
        System.out.println("--------------------------------------------");

        System.out.println("哈哈\"发文件了");

        System.out.println("--------------------------------------------");
        int i =10;
        System.out.println("i++ = " + i++);
        System.out.println("++i = " + ++i);
        System.out.println("i = " + i);
    }

}