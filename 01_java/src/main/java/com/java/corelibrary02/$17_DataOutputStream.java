package com.java.corelibrary02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 * 计算机只能识别二进制数据,早期就是电信号。为了方便计算机可以识别各个国家的文字,
 * 就需要将各个国家的文字采用数字编号的方式进行描述并建立对应的关系表,该表就叫做编码表。
 *
 */

public class $17_DataOutputStream {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("d:/a.txt"));
            int num = 66; // B
            dos.writeInt(num);
            System.out.println("写入数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != dos) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}