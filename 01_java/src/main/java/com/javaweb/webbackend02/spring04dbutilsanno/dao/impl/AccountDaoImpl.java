package com.javaweb.webbackend02.spring04dbutilsanno.dao.impl;

import com.javaweb.webbackend02.spring04dbutilsanno.bean.Account;
import com.javaweb.webbackend02.spring04dbutilsanno.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository // 相当于配置了bean标签
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> selectAll() {
        List<Account> list = null;
        String sql = "select * from tess.account";
        try {
            // 执行sql
            list = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public Account selectWhereId(Integer id) {
        Account account = null;
        String sql = "select * from tess.account where id = ?";
        try {
            account = queryRunner.query(sql, new BeanHandler<Account>(Account.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return account;
    }

    @Override
    public void insert(Account account) {
        String sql = "insert into tess.account values(null,?,?)";
        try {
            queryRunner.update(sql, account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        String sql = "update tess.account set name=?,money=? where id=?)";
        try {
            queryRunner.update(sql, account.getName(),account.getMoney(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from tess.account where id=?";
        try {
            queryRunner.update(sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
