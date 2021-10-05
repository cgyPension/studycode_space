package com.javaweb.webbackend02.spring04dbutilsanno.service.impl;

import com.javaweb.webbackend02.spring04dbutilsanno.bean.Account;
import com.javaweb.webbackend02.spring04dbutilsanno.dao.AccountDao;
import com.javaweb.webbackend02.spring04dbutilsanno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/1
 * Description:
 */

@Service("accountService") // 相当于配置了bean标签 id属性
public class AccountServiceImpl implements AccountService {
    @Autowired //使用在字段上用于根据类型依赖注入
    private AccountDao accountDao;

/*  // 注解注入时不需要set方法
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    @Override
    public List<Account> selectAll() {
        return accountDao.selectAll();
    }

    @Override
    public Account selectWhereId(Integer id){
        return accountDao.selectWhereId(id);
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