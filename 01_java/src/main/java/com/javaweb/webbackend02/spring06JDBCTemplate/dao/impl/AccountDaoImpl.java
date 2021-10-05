package com.javaweb.webbackend02.spring06JDBCTemplate.dao.impl;

import com.javaweb.webbackend02.spring05AOP.utils.ConnectionUtils;
import com.javaweb.webbackend02.spring06JDBCTemplate.bean.Account;
import com.javaweb.webbackend02.spring06JDBCTemplate.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao") // 相当于配置了bean标签
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outUser, Double money) {
        String sql = "update test.account set money = money-? where name= ?";
        jdbcTemplate.update(sql,money,outUser);
    }

    @Override
    public void in(String inUser, Double money) {
        String sql = "update test.account set money = money+? where name= ?";
        jdbcTemplate.update(sql,money,inUser);
    }

    @Override
    public List<Account> selectAll() {
        // 需要用到jdbcTemplate
        String sql = "select * from test.account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }

    @Override
    public Account selectWhereId(Integer id) {
        String sql = "select * from test.account where id= ?";
        Account account= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class),id);
        return account;
    }

    @Override
    public void insert(Account account) {
        String sql = "insert into test.account values(null,?,?)";
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    @Override
    public void update(Account account) {
        String sql = "update test.account set money = ? where name= ?";
        jdbcTemplate.update(sql,account.getMoney(),account.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete test.account where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
