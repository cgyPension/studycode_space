package com.java.corelibrary02;

import java.io.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description: 字节流 读写文件 图片 视频等
 */

public class $13_FileByteCopy {
    public static void main(String[] args) {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream("d:/a图.png");
            fw = new FileOutputStream("d:/b图.png");

            // 方式一：以单个字节为单位进行拷贝，也就是每次读取一个字节后再写入一个字节
            // 缺点：文件稍大时，拷贝的效率很低
/*            int res = 0;
            while ((res = fr.read())!=-1) {
                fw.write(res);
            }*/

            // 方式二：准备一个和文件大小一样的缓冲区 一次性将文件中的所有内容取出到缓冲区 然后一次性写入进去
            // 缺点：文件过大时 缓冲区 真实物理内存不足
            /*int len = fr.available();
            System.out.println("获取到的文件大小是：" + len);
            byte[] bArr = new byte[len];
            int res = fr.read(bArr);
            System.out.println("实际读取到的文件大小是：" + res);
             fw.write(bArr);*/

            // 方式三：准备一个相对适当的缓冲区,分多次将文件拷贝完成
            byte[] bArr = new byte[1024];
            int res =0;
            while ((res = fr.read())!=-1) {
                fw.write(bArr,0,res);
            }

            System.out.println("文件拷贝成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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