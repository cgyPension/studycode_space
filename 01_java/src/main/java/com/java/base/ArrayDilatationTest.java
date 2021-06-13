package com.java.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 自定义数组扩容规则，当已存储元素数量达到总容量的80%时，扩容1.5倍。
 * 例如，总容量是10，当输入第8个元素时，数组进行扩容，容量从10变15。
 */
public class ArrayDilatationTest {

    public static void main(String[] args) {

        // 1.提示用户输入要声明数组的容量并使用变量记录
        System.out.println("请输入要申明数组的容量：");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        // 2.根据用户输入的长度声明一个int类型的数组并准备一个变量负责记录数组中有效元素的个数
        int[] arr = new int[len];
        int cnt = 0;

        // 3.提示用户输入整数并放入数组中，当输入第8个元素时对数组进行1.5倍的扩容并时刻打印数组中的容量
        while (true) {
            System.out.println("请输入第" + (cnt+1) + "个整数数据(输入0退出)：");
            arr[cnt++] = sc.nextInt();
            if (0 == arr[cnt-1]) {
                System.out.println("数组扩容算法测试完毕！");
                break;
            }
            System.out.println("用户输入的数据是：" + arr[cnt-1] + "，此时数组中有效元素是：" + cnt + "个，数组的容量是" + arr.length);
            System.out.println("数组中的全部元素是：" + Arrays.toString(arr));
            // 当有效数组的个数达到总容量的80%时申请1.5倍容量的新数组，然后将原始数组中的数据内容拷贝过去
            if (cnt*1.0/arr.length >= 0.8) {
                int[] temp = new int[arr.length + (arr.length >> 1)];
                System.out.println("新申请的数组大小是：" + temp.length);
                System.arraycopy(arr, 0, temp, 0, cnt);
                arr = temp;
            }
        }
    }
}
