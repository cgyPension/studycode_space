package com.javaweb.webbackend02.spring06JDBCTemplate.dao;

import com.javaweb.webbackend02.spring06JDBCTemplate.bean.Account;

import java.util.List;

public interface AccountDao {

    // 转出操作
    public void out(String outUser,Double money);
    // 转入操作
    public void in(String inUser,Double money);

    public List<Account> selectAll();

    public Account selectWhereId(Integer id);

    public void insert(Account account);

    public void update(Account account);

    public void delete(Integer id);

}
