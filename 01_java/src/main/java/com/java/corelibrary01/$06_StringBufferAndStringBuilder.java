package com.java.corelibrary01;

/**
 * @author GyuanYuan Cai
 * 2021/6/21
 * Description:
 *
 * 可变字符串
 *由于String类描述的字符串内容是个常量不可改变,当需要在Java代码中描述大量类似的字符串时,只能单独申请和存储,此时会造成内存空间的浪费。
 * 为了解决上述问题,可以使用java.lang.StringBuilder类和java.lang.StringBuffer类来描述字符序列可以改变的字符串,
 * 如: "ab".
 * StringBuffer类是从jdk1.0开始存在,属于线程安全的类,因此效率比较低。
 * StringBuilder类是从jdk1.5开始存在,属于非线程安全的类,效率比较高。
 */

public class $06_StringBufferAndStringBuilder {
    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder();
        System.out.println("sb1 = " + sb1);
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("容量是： " + sb1.capacity()); // 默认是 16
        System.out.println("长度是： " + sb1.length());
        System.out.println("--------------------------------------------------------------------------");

        StringBuilder sb2 = new StringBuilder(20);
        System.out.println("sb2 = " + sb2);
        System.out.println("容量是： " + sb2.capacity());
        System.out.println("长度是： " + sb2.length()); // 0

        System.out.println("--------------------------------------------------------------------------");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println("sb3 = " + sb3);
        System.out.println("容量是： " + sb3.capacity()); // 16 + 5
        System.out.println("长度是： " + sb3.length()); // 0

        System.out.println("--------------------------------------------------------------------------");
        StringBuilder sb4 = sb3.insert(0, "abc"); // 从开始插入
        System.out.println("sb3 = " + sb3); // abchello 返回调用对象自己的引用
        System.out.println("sb4 = " + sb4); // abchello

        System.out.println("末尾追加：" + sb4.append("world")); // 末尾追加
        // 当字符串的长度超过了字符串对象的初始容量时，该字符串对象会自动扩容
        // 底层采用byte数组来存放所有的字符内容。

        System.out.println("--------------------------------------------------------------------------");
        sb4.deleteCharAt(3); // 删除打那个字符
        sb4.delete(0,3); // 左闭右合

        sb4.setCharAt(0,'x'); // 将下标为0的字符 修改为'a'

        System.out.println(sb4.replace(1, 4, "bcd")); // 将下标为1 到 3 的字符 替换为

        System.out.println("实现查找功能 " + sb4.indexOf("w")); // lastIndexOf 从后往前找

        System.out.println("字符串反转功能 "+sb4.reverse());

        //7.笔试考点
        // 考点—：既然tringBuilder类的对象本身可以修改,那么为什么成员方法还有返回值呢?
        // 解析：为了连续调用
        sb4. reverse().append("1").append("2").insert(0, "3").delete(0, 1).reverse();
        // 考点二：如何实现stringBuilder类型和String类型之间的转换呢？

        //考点二：如何实现stringBuilder类型和string类型之间的转换呢？
        String str3 = sb3.toString();
        StringBuilder sb5 = new StringBuilder(str3);
        // 考点三:string, StringBuilder, stringBuffer之间效率谁高?排列如何?
        // string < stringBuffer < stringBuilded
    }

}