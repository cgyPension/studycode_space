package com.java.corelibrary01;

/**
 * @author GyuanYuan Cai
 * 2021/6/20
 * Description:
 */

public class $05_Reg {
    public static void main(String[] args) {
        // 匹配银行卡密码 6位数字组成
        String reg1 = "^[0-9]{6}";
        String reg2 = "[0-9]{6}";
        String reg3 = "\\d{6}";
        String reg4 = "[1-9]\\d{4,14}"; // 匹配QQ号码规则

        String str1 = "123456";

        System.out.println("str1.matches(reg3) = " + str1.matches(reg3));

        System.out.println("-----------------------------StringReplace---------------------------------------");
        String str2 = "1001,yijing,26";
        // 按照逗号对字符串进行切割
        String[] sArr = str2.split(",");
        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }
        System.out.println("将字符串中的，字符替换为/：" + str2.replace(",", "/"));

        System.out.println("利用正则替换第一个匹配到的字符： " + str2.replaceFirst("\\d+", "#"));
        // 将所有字母字符串替换为 “￥￥￥”
        System.out.println(str2.replaceAll("[a-z]", "￥"));

    }

}