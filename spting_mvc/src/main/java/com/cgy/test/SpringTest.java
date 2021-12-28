package com.cgy.test;

import com.cgy.bean.Account;
import com.cgy.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/24
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testSpring(){
        List<Account> accounts = accountService.selectAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}