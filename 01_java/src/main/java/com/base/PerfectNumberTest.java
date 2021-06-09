package com.base;

/**
 * 编程找出1000以内的所有完数并打印出来。
 * 所谓完数就是一个数恰好等于它的因子之和，如：6=1＋2＋3
 */
public class PerfectNumberTest {

    public static void main(String[] args) {

        // 1.使用for循环遍历1 ~ 1000之间的所有整数
        for (int i = 1; i <= 1000; i++) {
            // 3.针对每个当前i的数据需要找出1 ~ i-1之间的所有因子并累加起来
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (0 == i%j) {
                    sum += j;
                }
            }
            // 2.针对每个当前i的数据判断是否为完数，若是则打印，否则不打印
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
