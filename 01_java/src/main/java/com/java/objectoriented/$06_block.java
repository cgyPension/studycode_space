package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/13
 * Description:
 */

public class $06_block {

    // 当需要在执行构造方法体之前做一些准备工作时,则将准备工作的相关代码写在构造块中即可,比如:对成员变量进行的统一初始化操作 (2)
    {
        System.out.println("代码块");
    }

    // 静态代码块随着类的加载而准备 所以无论创建多少次只会执行一次 会先于代码块执行 (1)
   static  {
        System.out.println("静态 代码块");
    }

    public $06_block() { // (3)
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        $06_block p1 = new $06_block();
    }
}