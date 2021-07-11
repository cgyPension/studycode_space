package com.java.corelibrary01;

/**
 * @author GyuanYuan Cai
 * 2021/7/11
 * Description:
 */

public class $16_Student implements Comparable<$16_Student> {
    private String name;
    private int age;

    public $16_Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "$16_Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo($16_Student o) {
        // return 0; // 调用对象和参数对象相等 调用对象就是新增加的对象
        // return -1; // 调用对象小于参数对象
        // return 1; // 调用对象大于参数对象//
        // return this.getName().compareTo(o.getName());// 比较姓名 调了String默认的比较器
        // return this.getAge() - o.getAge(); // 比较年龄
        // 姓名相同时候比较年龄
/*        int i = this.getName().compareTo(o.getName());
        if (0 == i) {
            return this.getAge() - o.getAge();
        }
        return i;*/
        int i = this.getName().compareTo(o.getName());
        return 0 != i ? i : this.getAge() - o.getAge();
    }
}