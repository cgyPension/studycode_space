package com.javaweb.webbackend02.spring01IOC.service.impl;

import com.javaweb.webbackend02.spring01IOC.dao.UserDao;
import com.javaweb.webbackend02.spring01IOC.service.UserService;
import com.javaweb.webbackend02.spring01IOC.utils.BeanFactory;

/**
 * @author GyuanYuan Cai
 * 2021/9/29
 * Description:
 */

public class UserServiceImpl implements UserService {
    @Override
    public void show() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //调用dao层方法  传统方式  存在编译期依赖:耦合重
        //UserDaoImpl userDao = new UserDaoImpl();

        //反射 存在硬编码问题 用配置文件抽取出来 beans.xml  （IOC容器）
        //UserDaoImpl userDao = (UserDaoImpl)Class.forName("com.javaweb.spring.dao.impl.UserDaoImpl").newInstance();
        UserDao userDao = (UserDao) BeanFactory.getBean("userDaoImpl");
        userDao.show();
    }
}