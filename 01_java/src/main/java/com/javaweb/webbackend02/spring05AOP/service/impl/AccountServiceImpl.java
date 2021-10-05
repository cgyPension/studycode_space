package com.javaweb.webbackend02.spring05AOP.service.impl;

import com.javaweb.webbackend02.spring05AOP.bean.Account;
import com.javaweb.webbackend02.spring05AOP.dao.AccountDao;
import com.javaweb.webbackend02.spring05AOP.service.AccountService;
import com.javaweb.webbackend02.spring05AOP.utils.TransactionManager;
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
/*    @Autowired
    private TransactionManager transactionManager;*/

    // 转账方法切入点添加上事务控制的效果
    @Override
    public void transfer(String outUser, String inUser, Double money) {
/*        // 开始事务
        transactionManager.beginTransaction();
        try {
            // 减钱
            accountDao.out(outUser,money);
            // 加钱
            accountDao.in(inUser,money);
            // 手动提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            transactionManager.rollback();
        }finally {
            // 释放资源
            transactionManager.release();
        }*/


        // 减钱
        accountDao.out(outUser,money);
        // 加钱
        accountDao.in(inUser,money);
    }

    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}