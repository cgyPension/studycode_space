package com.javaweb.webbackend02.spring02IOC.factory;

import com.javaweb.webbackend02.spring02IOC.dao.UserDao;
import com.javaweb.webbackend02.spring02IOC.dao.impl.UserDaoImpl;

/**
 * @author GyuanYuan Cai
 * 2021/9/29
 * Description:
 */

public class DynamicFactoryBean {

    public  UserDao createUserDao(){
        return new UserDaoImpl();
    }
}