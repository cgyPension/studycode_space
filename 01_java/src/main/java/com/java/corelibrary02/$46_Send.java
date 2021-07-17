package com.java.corelibrary02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: UDP
 */

public class $46_Send {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] bArr = "hello".getBytes();
            DatagramPacket dp = new DatagramPacket(bArr, bArr.length, InetAddress.getLocalHost(), 8888);
            ds.send(dp);
            System.out.println("发送数据成功！");

            byte[] bArr2 = new byte[20];
            DatagramPacket dp2 = new DatagramPacket(bArr2, bArr2.length);
            ds.receive(dp2);
            System.out.println("接收到的回发消息是："+new String(bArr2,0,dp2.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != ds) {
                ds.close();
            }
        }

    }

}