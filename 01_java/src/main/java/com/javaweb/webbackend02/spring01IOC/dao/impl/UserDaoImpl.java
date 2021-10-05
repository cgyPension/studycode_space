package com.javaweb.webbackend02.spring01IOC.dao.impl;

import com.javaweb.webbackend02.spring01IOC.dao.UserDao;

/**
 * @author GyuanYuan Cai
 * 2021/9/29
 * Description:
 */

public class UserDaoImpl implements UserDao {

    @Override
    public void show() {
        System.out.println("dao被调用了，打印！！！");
    }
}