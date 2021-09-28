package com.javaweb.webbackend02.dao;

import com.javaweb.webbackend02.bean.Orders;
import com.javaweb.webbackend02.bean.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.io.IOException;
import java.util.List;


public interface OrdersMapperAnno {

    // 一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
    @Select("select * from test.orders")
    @Results({ //代替的就是resultMap标签id标签 result标签
            @Result(property="id",column="id",id = true),// id = true 主键属性
            @Result(property="ordertime",column="ordertime"),
            @Result(property="total",column="total"),
            @Result(property="uid",column="uid"),
            @Result(property="user",javaType = User.class,column = "uid",one = @One(select = "com.javaweb.webbackend02.dao.UserMapperAnno.selectAllWhereId",fetchType = FetchType.EAGER)),
    })
    public List<Orders> selectOrdersAllWithUser() throws IOException;

    // 一对一嵌套查询：查询所有订单 及用户信息
    public List<Orders> selectOrdersAllWithUser2() throws IOException;

    // 根据uid查询对应订单 用在user的一对多关联查询
    @Select("select * from test.orders where uid = #{uid}")
    public List<Orders> selectAllWhereUid(Integer uid) throws IOException;


}
