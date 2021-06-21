package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/13
 * Description:
 */

public class $01_Person {
    String name;
    int age;

    // 无参构造器 默认
    public $01_Person() {
        System.out.println("我是无参构造器");
    }

    // 有参构造器
    public $01_Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("我是有参构造器");
    }

    // 成员方法属于类的内部成员 可以直接通过.调用
    void show() {
        System.out.println("name = " + name + ", age = " + age);
    }

    void show(int i) {// 与参数变量名无关
        System.out.println("方法重载，体系现的是形参（类型、数量、顺序）不同 " + i);
    }

    // 可变参数
    void showArgument(String...args){
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }
    }

    // alt+ins 自定义成员方法将姓名修改为指定数值的行为
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        $01_Person p = new $01_Person();
        System.out.println("p.name = " + p.name);
        System.out.println("p.age = " + p.age);
        p.name = "tuhao";
        p.setAge(18);
        // 调用成员方法
        p.show();
        p.showArgument("11","22","33");
        System.out.println("p.getName() = " + p.getName());

        $01_Person p2 = new $01_Person("李白",13);
        p2.show();
        // 调用重载的成员方法
        p2.show(66);
    }

}