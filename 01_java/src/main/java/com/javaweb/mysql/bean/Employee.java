package com.javaweb.mysql.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GyuanYuan Cai
 * 2021/7/18
 * Description: 成员变量对应一张表
 */
@Data
public class Employee implements Serializable {
    private int eid;
    private String ename;
    private int age;
    private String sex;
    private double salary;
    private Date empdate;
}