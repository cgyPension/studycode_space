package com.javaweb.webbackend02.dao;

import com.javaweb.webbackend02.bean.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    public List<User> selectAll() throws IOException;
}
