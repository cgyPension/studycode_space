package com.java.corelibrary01;

import org.apache.commons.lang3.StringUtils;

import javax.lang.model.element.VariableElement;

/**
 * @author GyuanYuan Cai
 * 2021/6/19
 * Description:
 */

public class $04_String {
    public static void main(String[] args) {
        //  String可以直接字符串赋值
        String str1 = "abc";
        String str2 = "abc";
        System.out.println("验证常量池： " + str1 == str2); // 比较的是地址

        System.out.println("-------------------------------------------------------------------------------");
        byte[] barr = {97,98,99,100,101};//char
        // 使用字节数组中的一部分内容来构造对象，表示使用数组barr中下标从1开始的3个字节构造字符串对象
        String str3 = new String(barr, 1, 3);
        System.out.println("str3 = " + str3); // bcd


        System.out.println("-------------------------------------------------------------------------------");
        String str4 = "hello"; // 1个对象 存放在常量池中
        String str5 = new String("hello"); // 2个对象 1个在常量池中，1个在堆区

        // 常量优化机制 变量没有
        String str6 = "hel" + "lo";
        System.out.println(str4 == str6); // true 比较的是地址

        String str7 = "hel";
        String str8 = str7 + "lo";
        System.out.println(str4 == str8); // false 比较的是地址

        System.out.println("------------------------------StringByteChar--------------------------------------");
        // 将String类型转为byte数组
        // 先将字符串拆分为字符 再将每个字符转换为byte类型 也就是获取所有字符的ASCII
        byte[] bArr = str4.getBytes();
        for (int i = 0; i < bArr.length; i++) {
            System.out.println("下标为i的元素是 " + bArr[i]);
        }
        // 将byte数组转回String
        String str9 = new String(bArr);
        System.out.println("转会字符串为 " + str9);

        char[] cArr = str4.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            System.out.println("下标为i的元素是 " + cArr[i]);
        }
        String str10 = new String(cArr);
        System.out.println("转会字符串为 " + str10);

        System.out.println("--------------------------------------------------------------------");

        System.out.println("字符串的长度是：" + str4.length());
        System.out.println("下标为0的字符是： " + str4.charAt(0));
        System.out.println("下标为1的字符是：" + str4.charAt(1));

        for (int i = 0; i < str4.length(); i++) {
            System.out.println("下标为"+i+"的字符是：" + str4.charAt(i)); // h e l l o
        }

        // 判断字符串是否为空
        System.out.println(0 == str4.length() ? "字符串为空" : "字符串不为空");
        System.out.println(str4.isEmpty() ? "字符串为空" : "字符串不为空");
         // 这个方法 ""   " " 空字符串也判断为空
        System.out.println(StringUtils.isBlank(str4) ? "字符串为空" : "字符串不为空");

        System.out.println("-----------------------------判读字符串是不是回文---------------------------------------");
        String str11 = "上海自来水来自海上";
        for (int i = 0; i < str11.length()/2; i++) {
            if (str11.charAt(i)!=str11.charAt(str11.length()-i-1)) {
                System.out.println(str11+"不是回文！");
                return;
            }
            System.out.println(str11+"是回文！");
        }

        System.out.println("-----------------------------StringCompare---------------------------------------");
        // 与其他字符串比较大小
        System.out.println(str4.compareTo("world")); // -15
        System.out.println(str4.compareTo("haha")); // 4
        System.out.println(str4.compareToIgnoreCase("HELLO")); // 0 忽略大小写

        System.out.println("-----------------------------------------------------------------------");
        String str12 = "  love my love you love life  ";
        System.out.println("是否包含某个字符串(区分大小写) " + str12.contains("love"));
        System.out.println("全部转换成大写 " + str12.toUpperCase());
        System.out.println("全部转换成小写 " + str12.toLowerCase());
        System.out.println("去除开头和结尾的空格" + str12.trim());
        System.out.println("判断字符串是否以...开头 " + str12.startsWith("  love"));
        System.out.println("判断字符串是否以...结尾 " + str12.endsWith("life  "));
        System.out.println("用于判断字符串内容是否相等 " + "mm".equals(str12));

        System.out.println("-----------------------------StringIndex---------------------------------------");
        System.out.println("查找字符串的位置 " + str12.indexOf('a'));  // -1 代表查找失败
        System.out.println("查找字符串的位置 " + str12.indexOf(' ')); // 0
        System.out.println("反向查找字符串的位置 " + str12.lastIndexOf(' ')); // 29
        System.out.println("查找字符串的位置 " + str12.indexOf('l',5));  // 从第五个索引开始查找

        // 查找所有 love 出现的位置
        int pos = 0;
        while ((pos = str12.indexOf("love", pos)) != -1) {
            System.out.println("pos = " + pos);
            pos+="love".length();
        }

        System.out.println("-----------------------------StringSubString---------------------------------------");
        // 从下标为12开始截取字符
        System.out.println("截取字符串：" + str12.substring(12));
        // 左闭右开 截取到6 截取不到10
        System.out.println("截取字符串：" + str12.substring(6,10));


    }

}