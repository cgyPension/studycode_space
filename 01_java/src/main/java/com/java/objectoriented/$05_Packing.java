package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/13
 * Description: 封装
 */

public class $05_Packing {

    // 1,私有化成员变量,使用private关键字修饰
    // private关键字修饰表示私有的含义,也就是该成员变量只能在当前类的内部使用
    private int id; // 成员变量
    private String name;

    // 使用static关键字修饰成员变量表示静态的含义,此时成员变量由对象层级提升为类层级
    // 也就是整个类只有一份并被所有对象共享,该成员变量随着类的加载准备就绪
    // 与是否创建对象无关。
    private static String flag;

    //在非静态成员方法中既能访问非静态的成员又能访问静态的成员。(成员:成员变量+成员方法,静态成员被所有对象共享)
    // 在静态成员方法中只能访问静态成员不能访问非静态成员。(成员:成员变量+成员方法, 因为此时可能还没有创建对象)
    // 在以后的开发中只有隶属于类层级并被所有对象共享的内容才可以使用static关键字修饰。(不能滥用static关键字)

    //2,提供公有的get和set方法,并在方法体中进行合理值的判断
    // 使用public关键字修饰表示公有的含义,也就是该方法可以在任意位置使用
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setFlag(String flag) {
        $05_Packing.flag = flag;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getFlag() {
        return flag;
    }

    //自定义成员方法实现特征的打印
    // 什么修饰符都没有叫做默认的访问权限,级别介于private和public之间
    public void show(){
        System.out.println("show");
    }


    public static void main(String[] args) {
        $05_Packing p1 = new $05_Packing();
        p1.setFlag("hhh");
        $05_Packing p2 = new $05_Packing();
        System.out.println("p2.getFlag() = " + p2.getFlag());
        System.out.println("$05_Packing.flag = " + $05_Packing.flag);
    }
}