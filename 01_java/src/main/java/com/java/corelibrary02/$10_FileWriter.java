package com.java.corelibrary02;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 *
 * IO就是Input和Output的简写,也就是输入和输出的含义。
 *
 * 按照读写数据的基本单位不同,分为字节流和字符流。
 * 其中字节流主要指以字节为单位进行数据读写的流,可以读写任意类型的文件。
 * 其中字符流主要指以字符(2个字节)为单位进行数据读写的流,只能读写文本文件。
 *
 * 按照读写数据的方向不同,分为输入流和输出流(站在程序的角度)。
 * 其中输入流主要指从文件中读取数据内容输入到程序中,也就是读文件。
 * 其中输出流主要指将程序中的数据内容输出到文件中,也就是写文件。
 *
 * 按照流的角色不同分为节点流和处理流。
 * 其中节点流主要指直接和输入输出源对接的流。
 * 其中处理流主要指需要建立在节点流的基础之上的流。
 */

public class $10_FileWriter {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            // 若文件不存在 该流会自动创建新的空文件
            // 若存在 则会清空源文件的内容
            //fw = new FileWriter("d:/a.txt");
            // 以追加的方式创建对象去关联文件
            fw = new FileWriter("d:/a.txt",true);
            // 通过流对象写入数据内容 每当写入一个字符后则文件中的读写位置向后移动一位
            fw.write('a');

            // 准备一个字符数组
            char[] cArr = {'h', 'e', 'l', 'l', 'o'};
            // 将字符数组中的一部分内容写进去
            fw.write(cArr,1,3);
            // 将整个字符数组写进去
            fw.write(cArr);

            System.out.println("写入数据成功！");
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
        }
    }

}