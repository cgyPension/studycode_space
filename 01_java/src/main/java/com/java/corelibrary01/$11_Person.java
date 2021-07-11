package com.java.corelibrary01;

/**
 * @author GyuanYuan Cai
 * 2021/7/10
 * Description:
 *
 * 自定义泛型Person 其中T相当于形参数负责占位 具体数值由实参决定
 * <T> 看做是一种名字为T的数据类型即可
 *
 */

public class $11_Person<T> {
    private String name;
    private int age;
    private T gender;

    public $11_Person() {
    }

    public $11_Person(String name, int age, T gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 这个不是泛型方法 其实已经在建对象的时候确定了类型
    // 该方法不能使用static关键字修饰 因为该方法中的T需要在new对象时才能明确类型
    public /*static*/ T getGender() {
        return gender;
    }

    public void setGender(T gender) {
        this.gender = gender;
    }

    // 自定义方法实现将参数指定数组中的所有元素打印出来
    public static <T1> void/*T1*/  printArray(T1[] arr) {
        for (T1 t1 : arr) {
            System.out.println("t1 = " + t1);
        }
    }

    @Override
    public String toString() {
        return "$11_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}