package com.java.corelibrary02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author GyuanYuan Cai
 * 2021/7/16
 * Description: UDP
 */

public class $45_Receive {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
            byte[] bArr = new byte[20];
            DatagramPacket dp = new DatagramPacket(bArr, bArr.length);

            System.out.println("等待数据的到来...");
            ds.receive(dp);
            System.out.println("接收到的数据内容是："+ new String(bArr));

            //
            byte[] bArr2 = "I received!".getBytes();
            DatagramPacket dp2 = new DatagramPacket(bArr2, bArr2.length, dp.getAddress(), dp.getPort());
            ds.receive(dp2);
            System.out.println("回发数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != ds) {
                ds.close();
            }
        }
    }
}