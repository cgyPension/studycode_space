package com.javaweb.webbackend02.spring05AOP.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author GyuanYuan Cai
 * 2021/10/3
 * Description:
 *
 * 事务管理器工具类:包含:开启事务、提交事务、回滚事务、释放资源
 *
 * 通知类
 */

@Component("TransactionManager")
@Aspect // 升级为切面类 配置切入点和通知关系
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Around("execution(* com.javaweb.webbackend02.spring05AOP.service.impl.AccountServiceImpl.transfer())")
    public Object around(ProceedingJoinPoint pjp) throws SQLException {
        Object proceed = null;
        try {
            // 开启事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
            proceed = pjp.proceed();
            // 提交事务
            connectionUtils.getThreadConnection().commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 回滚
            connectionUtils.getThreadConnection().rollback();
        }finally {
            connectionUtils.getThreadConnection().setAutoCommit(true);
            //将连接归还到连接池
            connectionUtils.getThreadConnection().close();
            //解除线程绑定
            connectionUtils.removeThreadConnection();
        }
        return proceed;
    }

    // 开启事务
    public void beginTransaction(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 提交事务
    public void commit(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 回滚
    public void rollback(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 释放资源
    public void release(){
        //  将手动事务改回自动提交事务
        Connection connection = connectionUtils.getThreadConnection();

        try {
            connection.setAutoCommit(true);
            //将连接归还到连接池
            connectionUtils.getThreadConnection().close();
            //解除线程绑定
            connectionUtils.removeThreadConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}