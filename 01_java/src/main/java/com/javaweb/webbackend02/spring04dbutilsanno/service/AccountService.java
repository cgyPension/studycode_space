package com.javaweb.webbackend02.spring04dbutilsanno.service;

import com.javaweb.webbackend02.spring04dbutilsanno.bean.Account;

import java.util.List;

public interface AccountService {

    public List<Account> selectAll();

    public Account selectWhereId(Integer id);

    public void insert(Account account);

    public void update(Account account);

    public void delete(Integer id);

}
