package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description: 局部内部类的定义和使用
 */

public class $18_AreaOuter {
    //定义一个局部变量进行测试,从Java8开始默认理解为final关键字修饰的变量
    private final int cnt = 1;

    public void show() {
        // 定义局部内部类，只在当前方法体的内部好使
        // 局部内部类只能在该方法的内部可以使用。
        // 局部内部类不能使用访问控制符和static关键字修饰符。
        class AreaInner {
            private int a = 2;

            public AreaInner() {
            }

            public void test() {
                System.out.println("cnt = " + cnt);
                System.out.println("a = " + a);
            }
        }
        // 局部内部类可以在方法体内部直接创建对象。
        AreaInner a1 = new AreaInner();
        a1.test();
    }

}