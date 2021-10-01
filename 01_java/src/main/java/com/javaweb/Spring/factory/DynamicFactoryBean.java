package com.javaweb.Spring.factory;

import com.javaweb.Spring.dao.UserDao;
import com.javaweb.Spring.dao.impl.UserDaoImpl;

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