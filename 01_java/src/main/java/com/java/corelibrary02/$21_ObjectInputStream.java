package com.java.corelibrary02;

import java.io.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $21_ObjectInputStream {
    public static void main(String[] args) {
        ObjectInputStream oos = null;
        try {
            oos = new ObjectInputStream(new FileInputStream("d:/a.txt"));
            Object obj = oos.readObject();
            System.out.println("读取到的对象是："+obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}