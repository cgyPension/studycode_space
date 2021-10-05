package com.javaweb.webbackend02.spring06JDBCTemplate;



import com.javaweb.webbackend02.spring06JDBCTemplate.bean.Account;
import com.javaweb.webbackend02.spring06JDBCTemplate.config.SpringConfig;
import com.javaweb.webbackend02.spring06JDBCTemplate.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author GyuanYuan Cai
 * 2021/9/28
 * Description:
 *
 *
 *
 * Spring的事务控制可以分为编程式事务控制和声明式事务控制。
 * 编程式（仅了解）
 * 开发者直接把事务的代码和业务代码耦合到一起，在实际开发中不用。
 * PlatformTransactionManager
 * TransactionDefinition
 * TransactionStatus
 *
 * 声明式
 * 开发者采用配置的方式来实现的事务控制,业务代码与事务代码实现解耦合,使用的AOP思想。
 *
 *
 * name:切点方法名称
 * isolation:事务的隔离级别
 * propagation:事务的传播行为
 * read-only:是否只读
 * timeout:超时时间
 *
 * *平台事务管理器配置(xml、注解方式)
 * 事务通知的配置(@Transactional注解配置)
 * 事务注解驱动的配置<tx: annotation-driven/>、@EnableTransactionManagement
 */
@RunWith(SpringJUnit4ClassRunner.class) // @RunWith指定juint的运行环境 SpringJUnit4ClassRunner是spring提供的juint运行环境的类
@ContextConfiguration(classes={SpringConfig.class})
public class $01_AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testInsert(){
        Account account = new Account();
        account.setName("jane");
        account.setMoney(100d);
        accountService.insert(account);
    }

    @Test
    public void testTransfer(){
        accountService.transfer("jane","cgy",100d);
    }


}