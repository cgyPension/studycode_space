package com.java.corelibrary02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $11_FileReader {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("d:/a.txt");

/*            int res = 0;
            while ((res = fr.read())!=-1) {
                System.out.println("读取到的单个字符是：" + (char)res);
            }*/

            // 准备一个数组来保存读取到的数据内容
            char[] cArr = new char[5];
            // 期望读满字符数组中的一部分空间，也就是读取3个字符放入数组CArr中下标从1开始的位置上
            int res = fr.read(cArr,1,3);
            System.out.println("实际读取到的字符个数是："+res);
            for (char c : cArr) {
                System.out.println("读取到的单个字符是：" + (char)c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}