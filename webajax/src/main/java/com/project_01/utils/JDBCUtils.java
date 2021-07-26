package com.project_01.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author GyuanYuan Cai
 * 2021/7/25
 * Description:
 */

public class JDBCUtils {
    // 创建c3p0连接池
    private static DataSource dataSource = new ComboPooledDataSource();
    //1.获取 连接池对象
    public static DataSource getDataSource(){
        return dataSource;
    }
    //2.获取连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}