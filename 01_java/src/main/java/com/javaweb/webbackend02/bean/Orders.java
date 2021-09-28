package com.javaweb.webbackend02.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author GyuanYuan Cai
 * 2021/9/22
 * Description:
 */
@Data
public class Orders {
    private Integer id;
    private String ordertime;
    private Double total;
    private Integer uid;

    // 表示当前订单属于哪个用户
    private User user;
}