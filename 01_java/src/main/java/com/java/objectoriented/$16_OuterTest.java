package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description:
 */

public class $16_OuterTest {
    public static void main(String[] args) {
        $15_Outer o1 = new $15_Outer();
        // 引用内部类
        $15_Outer.Inner i1 = o1.new Inner();

    }
}