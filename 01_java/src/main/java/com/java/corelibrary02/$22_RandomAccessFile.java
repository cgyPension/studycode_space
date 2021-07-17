package com.java.corelibrary02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $22_RandomAccessFile {
    public static void main(String[] args) {
        // 创建RandomAccessFile类型的对象与d:/a.txt文件关联
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("d:/a.txt", "rw");
            // 对文件内容进行随机读写操作
            // 设置距离文件开头位置的偏移量 从文件开头文职向后偏移3个字节
            raf.seek(3);
            int res = raf.read();
            System.out.println("读取到的的那个字符是："+(char)res);
            res = raf.read();
            System.out.println("读取到的的那个字符是："+(char)res);
            raf.write('2');
            System.out.println("写入数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != raf) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}