package com.java.base;

/**
 * @author GyuanYuan Cai
 * 2021/6/6
 * Description:
 */

public class $06_ForWhile {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            Thread.sleep(1000); //睡眠1秒
        }


        // 打印奇数
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) System.out.println("i = " + i);
        }

        // 打印1~100总和
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);


        // continue 结束本次循环 进入下一次循环
        for (int i = 0; i < 20; i++) {
            if (0 == i % 5) continue;
            System.out.println("continue: = " + i);
        }


        // 使用无线循环 模拟聊天
 /*       boolean flag=true;
        for (;;) {
            System.out.println("请"+(flag?"张三":"李四")+"输入要发送的聊天内容");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            if ("bye".equals(str)) {
                System.out.println("聊天结束");
            } else {
                System.out.println((flag?"张三说：":"李四说：")+ str);
                flag=!flag;
            }
        }*/

        // 双层循环打印9*9乘法表  外层循环控制行数 内层循环控制列数
        outer:
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
                if (6 == j) break outer;
            }
            System.out.println();
        }

        // while循环更适合于明确循环条件但不明确循环次数的场合中
        // for 循环更适合于明确的循环次数或范围的场合中
        // while(true)等价于for(;;)都表示无限循环
        int i = 1;
        int sum2 = 0;
        while (i < 10) {
            sum2 += 1.0 / i;
            i++;
        }

        int i2=11;
        // 至少执行一次
        do {
            System.out.println("i2 = " + i2);
            i2++;
        }while (i<=10);


    }

}