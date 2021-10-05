package com.javaweb.webbackend02.mybatis.dao;

import com.javaweb.webbackend02.mybatis.bean.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    public List<User> selectAll() throws IOException;
}
