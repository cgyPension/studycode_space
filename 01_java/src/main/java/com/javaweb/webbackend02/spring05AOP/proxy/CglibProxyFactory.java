package com.javaweb.webbackend02.spring05AOP.proxy;

import com.javaweb.webbackend02.spring05AOP.service.AccountService;
import com.javaweb.webbackend02.spring05AOP.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @author GyuanYuan Cai
 * 2021/10/4
 * Description:
 */
@Component
public class CglibProxyFactory {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    /*
    * 该类就是采用glib动态代理来对目标类(AccountServiceImpl)进行方法(transfer)的动态增强(添加上事务控制)
    * */
    public AccountService createAccountServiceCglibProxy(){
        //编写cglib对应的API来生成代理对象进行返回
        // 参数1: 目标类的字节码对象
        // 参数2: 动作类,当代理对象调用目标对象中原方法时,那么会执行intercept方法
        AccountService accountService = (AccountService) Enhancer.create(this.accountService.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                try {

                    // 开始事务
                    transactionManager.beginTransaction();
                    // 被代理对象的原方法执行
                    method.invoke(CglibProxyFactory.this.accountService, objects);
                    // 手动提交事务
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    // 回滚
                    transactionManager.rollback();
                } finally {
                    // 释放资源
                    transactionManager.release();
                }
                return null;
            }
        });
        return accountService;
    }

}