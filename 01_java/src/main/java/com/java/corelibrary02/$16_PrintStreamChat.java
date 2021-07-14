package com.java.corelibrary02;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $16_PrintStreamChat {
    public static void main(String[] args) {
        System.out.println("请输入要发送的聊天内容：");

        // 由手册可知：构造方法需要的是Reader类型的引用,但Reader类是个抽象类, 实参只能传递子类的对象 字符流
        // 由手册可知： System.in代表键盘输入,而且是Inputstream类型的字节流
        BufferedReader br = null;
        PrintStream ps = null;
        boolean flag = true;
        try {
            System.out.println("请" + (flag ? "张三" : "李四") + "输入要发送的聊天内容: ");
            br = new BufferedReader(new InputStreamReader(System.in));
            ps = new PrintStream(new FileOutputStream("d:/a.txt"));
            while (true) {
                String str = br.readLine();
                // 判断用户输入的内容是否为"bye"，若是则聊天结束
                if ("bye".equals(str)) {
                    System.out.println("聊天结束！");
                    break;
                }
                LocalDateTime todayDateTime = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String sayTime = dtf.format(todayDateTime);
                ps.println( sayTime+":"+(flag?"张三说: ":"李四说:") + str);
                flag = !flag;
            }
            ps.println(); // 写入空行与之前的聊天记录隔开
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != ps) {
                ps.close();
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