package com.java.objectoriented;

//import static 静态导入

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description:
 */

public class $10_final {

    //final关键字修饰类体现在该类不能被继承。-主要用于防止滥用继承 :java.lang.String类等。

    //final关键字修饰成员方法体现在该方法不能被重写但可以被继承。
    // 主要用于防止不经意间造成重写,如: java.text.Dateformat类中format方法等。

    //final关键字修饰成员变量体现在该变量必须初始化且不能改变。
    // -主要用于防止不经意间造成改变,如: java.lang.Thread类中MAX_PRIORITY等。

    // 在以后的开发中很少单独使用final关键字来修饰成员变量,
    // 通常使用public static final关键字共同修饰成员变量来表达常量的含义,
    // 常量的命名规范要求是所有字母都要大写,不同的单词之间采用下划线连。
    public static void main(String[] args) {

    }

}