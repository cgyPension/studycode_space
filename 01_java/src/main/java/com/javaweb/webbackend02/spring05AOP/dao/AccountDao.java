package com.javaweb.webbackend02.spring05AOP.dao;

import com.javaweb.webbackend02.spring05AOP.bean.Account;

import java.util.List;

public interface AccountDao {
    // 转出操作
    public void out(String outUser,Double money);
    // 转入操作
    public void in(String inUser,Double money);

}
