package com.java.base;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description: 操作符 算术运算符
 */

public class $03_Arithmetic {
    public static void main(String[] args) {
        // 当两个整数相除时结果只保留整数部分，丢弃小数部分
        System.out.println(5/2); // 2
        System.out.println((double) 5/2); // 2.5
        System.out.println(5*1.0/2);  // 2.5

        // 0不能作除数 + 要是有一个字符串就会被当成连接符
    }

}