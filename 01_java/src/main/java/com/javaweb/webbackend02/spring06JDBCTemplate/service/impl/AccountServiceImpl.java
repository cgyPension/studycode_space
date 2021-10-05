package com.javaweb.webbackend02.spring06JDBCTemplate.service.impl;

import com.javaweb.webbackend02.spring06JDBCTemplate.bean.Account;

import com.javaweb.webbackend02.spring06JDBCTemplate.dao.AccountDao;
import com.javaweb.webbackend02.spring06JDBCTemplate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/1
 * Description:
 */

@Service("accountService") // 相当于配置了bean标签 id属性
//@Transactional // 对所有方法进行事务控制
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = -1,readOnly = false)
    @Override
    public void transfer(String outUser, String inUser, Double money) {
        accountDao.out(outUser,money);
        accountDao.in(inUser,money);
    }

    @Override
    public List<Account> selectAll() {
        List<Account> accounts = accountDao.selectAll();
        return accounts;
    }

    @Override
    public Account selectWhereId(Integer id) {
        Account account = accountDao.selectWhereId(id);
        return account;
    }

    @Override
    public void insert(Account account) {
        accountDao.insert(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }
}