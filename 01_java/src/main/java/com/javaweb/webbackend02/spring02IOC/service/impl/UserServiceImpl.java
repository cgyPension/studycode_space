package com.javaweb.webbackend02.spring02IOC.service.impl;

import com.javaweb.webbackend02.spring02IOC.dao.UserDao;
import com.javaweb.webbackend02.spring02IOC.service.UserService;

/**
 * @author GyuanYuan Cai
 * 2021/9/29
 * Description:
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 构造方法注入
/*
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
*/

    // set方法注入 常用
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void show() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Bean依赖注入
        // 获取到了spring上下文对象，借助上下文对象可以获取到IOC容器中的bean对象
/*        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用上下文对象从IOC容器中获取到了bean对象
        UserDao userDao = (UserDao)classPathXmlApplicationContext.getBean("userDaoImpl");*/

        // 构造方法注入 调用方法
        userDao.show();
    }
}