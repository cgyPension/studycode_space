package com.java.corelibrary02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: TCP
 */

public class $44_ServerThread extends Thread {
    private Socket s;

    public $44_ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            ps = new PrintStream(s.getOutputStream());
            //当没有数据发来时，下面的方法会形成阻塞
            while (true) {
                String s1 = br.readLine();
                InetAddress inetAddress = s.getInetAddress();
                System.out.println("客户端" + inetAddress + "发送的内容是： " + s1);
                if ("bye".equalsIgnoreCase(s1)) {
                    System.out.println("客户端" + inetAddress +"下线！");
                    break;
                }
                //实现服务器向客户端回发字符串内容"I received!"
                ps.println("I received!");
                System.out.println("服务器发送数据成功! ");
            }
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
            // 关闭Socket 并释放有关的资源
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}