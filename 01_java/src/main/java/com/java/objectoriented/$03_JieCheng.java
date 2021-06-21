package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/13
 * Description:
 */

public class $03_JieCheng {
    int show(int n){
/*        int num = 1;
        for (int i = 1; i <=n; i++) {
            num*=i;
        }
        return num;*/

        // 递归
        if (1==n) return 1;
        return n*show(n-1);
    }

    // 费氏数列的计算并打印
    int show2(int n) {
/*
        // 递归有时候影响性能
        if (1 == n || 2 == n) {
            return 1;
        }
        return show2(n-1)+show2(n-2);
*/

        int a = 1;
        int b = 1;
        for (int i = 3; i <=n; i++) {
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        // 阶乘 1*100 从1开始乘
        $03_JieCheng jct = new $03_JieCheng();
        System.out.println("jct.show(5) = " + jct.show(5));
        System.out.println("jct.show2(5) = " + jct.show2(5));
    }

}