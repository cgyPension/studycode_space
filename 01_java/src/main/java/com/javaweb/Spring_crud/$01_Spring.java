package com.javaweb.Spring_crud;

import com.javaweb.Spring.service.UserService;
import com.javaweb.springIOC.dao.UserDao;
import com.javaweb.springIOC.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author GyuanYuan Cai
 * 2021/9/28
 * Description:
 *
·基于Spring的xml配置实现账户的CRUD案例
 */

public class $01_Spring {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //UserServiceImpl userService = new UserServiceImpl();
        // 获取到了spring上下文对象，借助上下文对象可以获取到IOC容器中的bean对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-dao.xml");
        // 使用上下文对象从IOC容器中获取到了bean对象
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

        userService.show();
    }

}