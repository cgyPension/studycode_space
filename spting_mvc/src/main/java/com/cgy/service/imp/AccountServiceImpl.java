package com.cgy.service.imp;

import com.cgy.service.AccountService;
import com.cgy.bean.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/24
 * Description:
 */

@Service
public class AccountServiceImpl implements AccountService {

    // 测spring 在ssm环境中的单独使用
    @Override
    public List<Account> selectAll() {
        System.out.println("selectAll执行了....");
        return null;
    }

    // 账户添加
    @Override
    public void save(Account account) {
        //调用 accountDao 的保存方法
    }

    //
    @Override
    public Account selectId(Integer id) {
        //调用 accountDao 的查询方法
        return null;
    }

    @Override
    public void update(Account account) {

    }
}