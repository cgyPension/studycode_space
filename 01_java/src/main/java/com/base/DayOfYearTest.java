package com.base;

import java.util.Scanner;

/**
 * 编程实现根据用户输入的年月日信息来计算这一年中的第几天并打印出来
 */
public class DayOfYearTest {

    public static void main(String[] args) {

        // 1.提示用户输入年月日信息并使用变量记录
        System.out.println("请输入年月日信息（年 月 日）：");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        // 2.统计该日期在这一天中的第几天并使用变量记录
        // 2.1 准备一个数组将每个月的天数存储起来，2月暂时按照28天处理
        int[] monthArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 2.2 准备一个变量记录本月的天数，再将该月份的前一个月到1月份之间的所有天数累加起来
        int days = day;
        for(int i = month-1; i >= 1; i--) {
            days += monthArr[i-1];
        }
        // 2.3 若该月份大于2月且该年份为闰年则需要总天数上加1
        if ((month > 2) && (0==year%4 && 0!=year%100 || 0==year%400)) {
            days++;
        }

        // 3.打印最终的结果
        System.out.println("该日期是这一年中的第" + days + "天！");
    }
}
