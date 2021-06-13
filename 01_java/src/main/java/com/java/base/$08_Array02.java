package com.java.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author GyuanYuan Cai
 * 2021/6/9
 * Description:
 */

public class $08_Array02 {
    public static void main(String[] args) {
        // 将第一个数组中的所有元素赋值到第二个数组中
        int[] arr = {11, 22, 33, 44, 55};
        int[] brr = new int[3];
/*        brr[0] = arr[1];
        brr[1] = arr[2];
        brr[2] = arr[3];*/
        for (int i = 0; i < brr.length; i++) {
            brr[i] = arr[i + 1];
        }

        // 可以使用Java官方提供的拷贝功能
        // 将数组arr中从1下标开始拷贝到 brr 的数组中
        // 赋值后brr变量中存放了arr所指向堆区的内存地址
        // 也就是brr和arr指向了同一块堆区空间

        System.arraycopy(arr, 1, brr, 0, 3);

        for (int i : brr) {
            System.out.println(i);
        }

        System.out.println("-----------------使用数组实现正整数中每个数字出现次数的统计------------");
   /*     System.out.println("请输入一个正整数");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // 准备一个长度为10的数组 默认值为0
        int[] arr3 = new int[10];
        int temp = num;
        // 拆分正整数中的每个数字并统计到数组中
        while (temp > 0) {
            arr3[temp % 10]++;
            temp /= 10;
        }
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] > 0) System.out.println("数字" + i + "出现了" + arr3[i] + "次！");
        }
*/
        System.out.println("-----------------------java.util.Arrays 工具类使用-----------------------------");
        System.out.println("输出数组中的内容："+Arrays.toString(arr));
        Arrays.fill(arr,10);// 使用10来填充数组中的每个元素
        System.out.println("输出数组中的内容："+Arrays.toString(arr));
        System.out.println(arr.equals(brr));// 判断内容和次数是否相等

        int[] arr1 = {85, 22, 343, 44, 55};
        Arrays.sort(arr1); // 从小到大进行排序
        System.out.println("输出数组中的内容："+Arrays.toString(arr1));
        System.out.println("85的下标是："+Arrays.binarySearch(arr1,85));

    }

}