package com.javaweb.webbackend02.spring05AOP.proxy;

import com.javaweb.webbackend02.spring05AOP.service.AccountService;
import com.javaweb.webbackend02.spring05AOP.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author GyuanYuan Cai
 * 2021/10/4
 * Description:
 */
@Component
public class JDKProxyFactory {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    /*
    * 采用JDK动态代理技术来生成目标类的代理对象
    * classLoader Loader, :类加载器:借助被代理对象获取到类加载器
    * class<?2[] interfaces, :被代理类所需要实现的全部按口
    * InvocationHandler h:当代理对象调用按口中的任意方法时,那么都会执行InvocationHandler linvoke方法
    *
    * */
    public AccountService createAccountServiceJDKProxy(){
        AccountService accountServiceProxy = (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override // proxy:当前的代理对象引用    method:被调用的目标方法的引用  args:被调用的目标方法所用到的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    if (method.getName().equals("transfer")) {
                        // 开始事务
                        transactionManager.beginTransaction();
                        // 被代理对象的原方法执行
                        method.invoke(accountService, args);
                        // 手动提交事务
                        transactionManager.commit();
                    } else {
                        method.invoke(accountService, args);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // 回滚
                    transactionManager.rollback();
                }finally {
                    // 释放资源
                    transactionManager.release();
                }
                return null;
            }
        });
        return accountServiceProxy;
    }

}