package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $07_Person {

    private String name;
    private int age;

    public $07_Person() {
    }

    public $07_Person(String name, int age) {
        this.name = name;
       setAge(age);
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

        if (age > 0 && age < 100) {
            this.age = age;
        } else {
            // System.out.println("年龄不合理！！！");
            try {
                throw new $06_AgeException("年龄不合理！！！");
            } catch ($06_AgeException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "$07_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}