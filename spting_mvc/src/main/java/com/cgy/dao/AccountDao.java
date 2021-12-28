package com.cgy.dao;

import com.cgy.bean.Account;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/24
 * Description:
 */

public interface AccountDao {

    public List<Account> selectAll();

    public void save(Account account);
}