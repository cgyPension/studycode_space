package com.javaweb.webbackend02.spring04dbutilsanno.dao;

import com.javaweb.webbackend02.spring04dbutilsanno.bean.Account;

import java.util.List;

public interface AccountDao {

    public List<Account> selectAll();

    public Account selectWhereId(Integer id);

    public void insert(Account account);

    public void update(Account account);

    public void delete(Integer id);

}
