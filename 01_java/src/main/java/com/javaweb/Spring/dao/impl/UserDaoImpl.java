package com.javaweb.Spring.dao.impl;

import com.javaweb.Spring.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author GyuanYuan Cai
 * 2021/9/29
 * Description:
 *
 * 注入数据的三种数据类型*1.i通数据类型2.引用数据类型3,集合数据类型
 *
 */

public class UserDaoImpl implements UserDao {
    //注入普通数据类型
    private String username;
    private Integer age;
    //注入集合数据类型
    private List<Object> list;
    //注入set集合数据类型
    private Set<Object> set;
    //注入array集合数据类型
    private Object[] array;
    private Map<String,Object> map;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void show() {
        System.out.println("dao被调用了，打印！！！");
    }

    @Override
    public void init() {
        System.out.println("初始化方法执行了....");
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法执行了....");
    }
}