package com.java.corelibrary02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description: 字符流
 */

public class $12_FileCharCopy {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("d:/a.txt");
            fw = new FileWriter("d:/b.txt");
            // 不断从输入流中读取数据内容写入到输出流中
            int res = 0;
            while ((res = fr.read())!=-1) {
                fw.write(res);
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