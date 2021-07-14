package com.java.corelibrary02;

import java.io.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $15_BufferedCharCopu {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new  BufferedReader(new FileReader("d:/a.png"));
            bw = new BufferedWriter(new FileWriter("d:/b.png"));

            String str;
            while ((str = br.readLine()) != null) { // 一行一行读
                bw.write(str);
                bw.newLine();// 当前系统的换行符
            }
            System.out.println("文件拷贝成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}