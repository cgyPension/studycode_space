package com.javaweb.webbackend02.spring05AOP.service;

import com.javaweb.webbackend02.spring05AOP.bean.Account;

import java.util.List;

public interface AccountService {
    // 转账方法
    public void transfer(String outUser,String inUser,Double money);

    public void insert();
    public void update();
    public void delete();

}
