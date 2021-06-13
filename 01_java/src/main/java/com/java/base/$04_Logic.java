package com.java.base;

/**
 * @author GyuanYuan Cai
 * 2021/5/31
 * Description:
 */

public class $04_Logic {

    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 && b2);
        System.out.println(b1 || b2);
        System.out.println(!b1);

        int n1 = 3;
        int n2 = 4;
        System.out.println(n2>n1?"是":"否");


/*        移位运算符(了解),
        <<左移运算符,用于将数据的二进制位向左移动,右边使用0补充,
        >>右移运算符,用于将数据的二进制位向右移动,左边使用符号位补充,
        >>>表示逻辑右移运算符,用于将数据的二进制位向右移动,左边使用0补充。
        */
    }
}