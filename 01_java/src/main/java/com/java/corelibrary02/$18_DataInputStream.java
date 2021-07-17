package com.java.corelibrary02;

import java.io.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $18_DataInputStream {
    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("d:/a.txt"));
            int res = dis.readInt();
            System.out.println("读取到的数据是："+res); // 66
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != dis) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}