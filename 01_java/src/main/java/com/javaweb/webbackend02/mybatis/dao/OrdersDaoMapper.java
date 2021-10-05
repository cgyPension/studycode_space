package com.javaweb.webbackend02.mybatis.dao;

import com.javaweb.webbackend02.mybatis.bean.Orders;

import java.io.IOException;
import java.util.List;


public interface OrdersDaoMapper {

    // 一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
    public List<Orders> selectOrdersAllWithUser() throws IOException;

    // 一对一嵌套查询：查询所有订单 及用户信息
    public List<Orders> selectOrdersAllWithUser2() throws IOException;

    // 根据uid查询对应订单
    public List<Orders> selectUid() throws IOException;
}
