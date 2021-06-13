package com.java.base;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author GyuanYuan Cai
 * 2021/6/12
 * Description:
 */

public class $09_TwoArray {
    public static void main(String[] args) {
        // 里面有多个一维数组
        int[][] arr1 = new int[2][3];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.println("arr1[" + i + "][" + j + "] = " + arr1[i][j]);
            }
        }

        int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        for (int[] ints : arr2) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        }

        int[][] arr3 = new int[3][];
        arr3[0] = new int[3];
        arr3[1] = new int[4];
        arr3[2] = new int[5];
        System.out.println("-----------------------杨辉三角-----------------------------");
        int[][] arr4 = new int[5][];
        for (int i = 0; i < 5; i++) {
            arr4[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                if (0 == j || i == j) {
                    arr4[i][j] = 1;
                } else {
                    arr4[i][j] = arr4[i-1][j] + arr4[i-1][j-1];
                }
            }
        }
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println();
        }



    }
}