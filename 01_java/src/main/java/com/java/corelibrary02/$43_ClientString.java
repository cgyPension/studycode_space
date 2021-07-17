package com.java.corelibrary02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: TCP
 */

public class $43_ClientString {
    public static void main(String[] args) {
        // 创建Socket类型的对象并提供服务器的主机名和端口号
        Socket s = null;
        PrintStream ps = null;
        Scanner sc = null;
        BufferedReader br = null;
        try {
            s = new Socket("127.0.0.1", 8888);
            //2.使用输入输出流进行通信
            // 实现客户端向服务器发送字符串内容"helLo"
            Thread.sleep(3000);
            ps = new PrintStream(s.getOutputStream());
/*            ps.println("hello");
            System.out.println("客户端发送数据成功！");*/

            sc = new Scanner(System.in);
            while (true) {
                System.out.println("请输入要发送的内容：");
                String str1 = sc.next();
                if ("bye".equalsIgnoreCase(str1)) {
                    System.out.println("聊天结束！");
                    break;
                }
                ps.println(str1);
                System.out.println("客户端发送数据成功！");

                // 接收服务器发送的内容
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //当没有数据发来时，下面的方法会形成阻塞
                String s1 = br.readLine();
                System.out.println("服务器发送的内容是： " + s1);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != sc) {
                sc.close();
            }

            if (null != ps) {
                ps.close();
            }

            // 关闭Socket 并释放有关的资源
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("连接服务器成功！");
    }

}