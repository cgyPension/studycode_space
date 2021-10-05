package com.javaweb.webbackend02.mybatis.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author GyuanYuan Cai
 * 2021/9/20
 * Description:
 */
@Data
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}