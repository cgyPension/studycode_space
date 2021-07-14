package com.java.corelibrary02;

import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/6/16
 * Description:
 */

public class $01_Exception {
    public static void main(String[] args) {
        // 非检测性异常 运行时异常 算术异常
        int a = 0;
        //System.out.println(5 / a); // 编译ok 运行阶段会发生算术异常 下面的代码不会执行
        if (0!=a) {
            System.out.println(5 / a);
        }

        // 检测性异常
        // Thread.sleep(1000); // 编译错误

        // 数组下标异常
        int[] arr = new int[5];
        int pos = 5;
        System.out.println(arr[pos]);
        if (pos > 0 && pos < 5) {
            System.out.println(arr[pos]);
        }

        // 空指正异常
        String str = null;
        //System.out.println(str.length());
        if (null!=str) {
            System.out.println(str.length());
        }

        // 类型转换异常
        Exception ex = new Exception();
        //IOException ie = (IOException) ex;
        if (ex instanceof IOException) {
            IOException ie = (IOException) ex;
        }


        // 数字格式异常
        String str2 = "123a";
       // System.out.println(Integer.parseInt(str2));
        if (str2.matches("\\d+")) {
            System.out.println(Integer.parseInt(str2));
        }

        System.out.println("程序正常结束了！");
    }

}