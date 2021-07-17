package com.java.corelibrary02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: TCP
 */

public class $42_ServerString {
    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;

        try {
            ss = new ServerSocket(8888);

            while (true) {
                System.out.println("等待客户端的连接请求...");
                s = ss.accept();
                System.out.println("客户端连接成功！");
                new $44_ServerThread(s).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}