package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description:
 */

public class $17_StaticOuter {
    // 外部类成员
//    private int cnt = 1;
    private static int cnt = 1;

    // 内部类
    public static class Inner {
        private int a=2;

        public Inner() {
        }
        public void show(){
            // 静态内部类 只能访问外部类静态属性
            System.out.println("内部类方法 打印外部类私有属性："+cnt);
            System.out.println("a = " + a);
        }
    }

}