package com.javaweb.FrontEndVisualization;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GyuanYuan Cai
 * 2021/7/24
 * Description:
 */
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User{
    private String name;
    @JsonIgnore  // bean转换成json时候 跳过这个字段
    private int age;
    @JsonFormat(pattern = "YYY-MM-dd") // 日期转换注解
    private Date birthday;
    private String address;

    public User() {
    }

    public User(String name, int age, Date birthday, String address) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}