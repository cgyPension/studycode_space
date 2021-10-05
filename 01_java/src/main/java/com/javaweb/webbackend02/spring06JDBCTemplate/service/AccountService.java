package com.javaweb.webbackend02.spring06JDBCTemplate.service;

import com.javaweb.webbackend02.spring06JDBCTemplate.bean.Account;

import java.util.List;

public interface AccountService {
    // 转账方法
    public void transfer(String outUser,String inUser,Double money);


    public List<Account> selectAll();

    public Account selectWhereId(Integer id);

    public void insert(Account account);

    public void update(Account account);

    public void delete(Integer id);
}
