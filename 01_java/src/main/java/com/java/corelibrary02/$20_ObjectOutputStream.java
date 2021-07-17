package com.java.corelibrary02;

import java.io.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $20_ObjectOutputStream {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
            $19_User user = new $19_User("jane", "121816", "29481205");
            oos.writeObject(user);
            System.out.println("写入对象成功！");
        } catch (IOException e) {
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