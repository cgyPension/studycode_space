package com.javaweb.webbackend02.spring05AOP.dao.impl;

import com.javaweb.webbackend02.spring05AOP.bean.Account;
import com.javaweb.webbackend02.spring05AOP.dao.AccountDao;
import com.javaweb.webbackend02.spring05AOP.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao") // 相当于配置了bean标签
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public void out(String outUser, Double money) {
        String sql="update test.account set money = money -? where name = ?";
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,outUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void in(String inUser, Double money) {
        String sql="update test.account set money = money +? where name = ?";
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,inUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
