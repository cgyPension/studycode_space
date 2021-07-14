package com.java.corelibrary02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $03_ExceptionThrows {

    // throws 是不断抛给下一级处理
    // try catch 才是捕获处理
    public static void show() throws IOException {
        FileInputStream fis = new FileInputStream("d:/a.txt");
        System.out.println("抛出异常后是否继续向下执行？？？");
        fis.close();
    }

    public static void test1() throws IOException {
        show();
    }

    public static void test2() throws IOException {
        test1();
    }

    // 不建议在main方法中抛出异常 JVM负担很重
    public static void main(String[] args) {
        try {
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------------");
        try {
            test2();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}