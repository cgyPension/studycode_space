package com.java.corelibrary01;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Map;
import java.util.regex.Matcher;

/**
 * @author GyuanYuan Cai
 * 2021/6/19
 * Description:
 */

public class $03_Math {
    public static void main(String[] args) {
        System.out.println("--------------------------------------Math-----------------------------------------");
        System.out.println("绝对值 " + Math.abs(-11)); // 11
        System.out.println("取两个数中的最大值 " + Math.max(10, 20)); // 20
        System.out.println("取两个数中的最小值 " + Math.min(10, 20));  // 10
        System.out.println("获取次方的结果是 " + Math.pow(2, 3)); // 8
        System.out.println("进行四舍五入的结果 " + Math.round(3.14)); // 3
        System.out.println("该整数的平方根 " + Math.sqrt(16));  // 4.0
        System.out.println("生成随机数 " + Math.random()); // 随机数

        System.out.println("-------------------------------------------------------------------------------");
        // 和hive的nvl一样
        System.out.println("apache返回第一个不为空的数：" + ObjectUtils.firstNonNull(null,"" ,55, null));

    }
}