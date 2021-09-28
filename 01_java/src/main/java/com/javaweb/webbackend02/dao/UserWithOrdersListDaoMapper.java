package com.javaweb.webbackend02.dao;

import com.javaweb.webbackend02.bean.User;
import com.javaweb.webbackend02.bean.UserWithOrdersList;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;


public interface UserWithOrdersListDaoMapper {

    // 一对多关联查询：查询所有的用户,同时还要查询出每个用户所关联的订单信息
    public List<User> selectUserWithOrdersList() throws IOException;

    // 多对多关联查询：查询所有的用户,同时还要查询出每个用户所关联的角色信息
    public List<User> selectUserWithRoleList() throws IOException;

    // 一对一嵌套查询
    public User selectId(Integer id) throws IOException;

    // 一对多嵌套查询 查询所有用户,与此同时查询出该用户具有的订单
    public List<UserWithOrdersList> selectUserWithOrdersList2() throws IOException;

    // 多对多嵌套查询 查询用户同时查询出该用户的所有角色
    public List<User> selectUserWithRoleList2() throws IOException;


}
