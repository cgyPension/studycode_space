package com.cgy.service;

import com.cgy.bean.Account;

import java.util.List;

public interface AccountService {
    public List<Account> selectAll();

    void save(Account account);

    Account selectId(Integer id);

    void update(Account account);
}
