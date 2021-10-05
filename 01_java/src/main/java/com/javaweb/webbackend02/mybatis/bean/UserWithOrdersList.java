package com.javaweb.webbackend02.mybatis.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/9/20
 * Description:
 */
@Data
public class UserWithOrdersList implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    //表示多方关系:集合:代表了当前用户所具有的订单列表
    private List<Orders> ordersList;

    // 表示多方关系:集合:代表了当前用户所具有的角色列表collection
    private List<Role> roleList;
}