package com.java.corelibrary02;

import java.io.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $14_BufferedByteCopy {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 默认的缓冲区为8g
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("d:/a.png"));
            outputStream = new BufferedOutputStream(new FileOutputStream("d:/b.png"));

            byte[] bArr = new byte[1024];
            int res = 0;
            while ((res = inputStream.read()) != -1) {
                outputStream.write(bArr, 0, res);
            }
            System.out.println("文件拷贝成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲区拷贝文件消耗时间为 " + (end - start));

    }

}