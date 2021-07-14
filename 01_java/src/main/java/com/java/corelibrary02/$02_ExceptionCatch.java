package com.java.corelibrary02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $02_ExceptionCatch {
    public static void main(String[] args) {
        // 选中代码后可以使用ctrl+alt+t来生成异常的捕获代码等
        // 手动处理异常和没有处理的区别：代码是否可以继续向下执行

        // 创建一个FileInputStream类型的对象与 d:/a.txt 文件关联 打开文件
       /* FileInputStream fis = null;
        try {
            System.out.println("1");
            fis = new FileInputStream("d:/a.txt");
            System.out.println("2");
        } catch (FileNotFoundException e) {
            System.out.println("3");
            e.printStackTrace();
            System.out.println("4");
        }finally {
            System.out.println("无论是否发生异常 一定会执行！");
        }

        // 关闭文件
        try {
            System.out.println("5");
            fis.close();
            System.out.println("6");
        } catch (IOException e) {
            System.out.println("7");
            e.printStackTrace();
            System.out.println("8");
        }


        System.out.println("程序正常结束了！");*/
    }

}