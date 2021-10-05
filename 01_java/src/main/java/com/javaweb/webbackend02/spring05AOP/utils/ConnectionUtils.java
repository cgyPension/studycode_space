package com.javaweb.webbackend02.spring05AOP.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author GyuanYuan Cai
 * 2021/10/3
 * Description:
 *
 * 连按工具类：从数据源中获取一个连按,并且将获取到的连按与线程进行绑定
 * ThreadLocal:线程内部的存储类,可以在指定的线程内存储数据key: threadLocal（当前线程)value:任意类型的值Connection
 */

@Component
public class ConnectionUtils {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // 获取当前线程上绑定连按：如果获取到的连接为空,那么就要从数据源中获取连按,并且放到ThreadLocal中(绑定到当前线程)
    public Connection getThreadConnection(){
        // 先从ThreadLocal上获取连接
        Connection connection = threadLocal.get();
        // 判断当前线程中获取一个连接 并且存入ThreadLocal中
        if (connection == null){
            // 从数据源中获取一个连接,并且存入ThreadLocal中
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    // 解除当前线程的连接绑定
    public void removeThreadConnection(){
        threadLocal.remove();
    }
}