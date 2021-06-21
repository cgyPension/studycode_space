package com.java.corelibrary01.lagou.string;

/**
 * 编程获取两个指定字符串中的最大相同子串并打印出来
 */
public class SameSubStringTest {

    public static void main(String[] args) {

        // 1.构造String类型的对象并初始化
        String str1 = "asdafghjka";
        String str2 = "aaasdfg";

        // 2.将短的那个串进行长度依次递减的子串与较长的串比较
        // 2.1 获取较短子串的长度
        int length = str2.length(); // 7
        // 2.2 使用外层for循环控制较短子串依次递减的功能
        for(int i = 0; i < length; i++){
            // 2.3 使用内层for循环控制长度固定时的所有子串情况
            for(int x = 0, y = length - i; y <= length; x++, y++) {
                // 根据下标获取所有的子串
                String subStr = str2.substring(x,y); // 0,7   0,6  1,7   0,5  1,6  2,7  ...
                // 若较长的字符串中包含该子串，则查找成果进行打印
                if(str1.contains(subStr)){
                    System.out.println("最大字串是：" + subStr);
                    return; // 结束当前方法
                }
            }
        }
    }
}
