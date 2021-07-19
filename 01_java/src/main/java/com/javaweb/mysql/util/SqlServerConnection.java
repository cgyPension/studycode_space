package com.javaweb.mysql.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.javaweb.mysql.conf.ConfigurationManager;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.javaweb.mysql.conf.Constants.*;

/**
 * @author GyuanYuan Cai
 * 2021-04-30
 * Description:
 */

public class SqlServerConnection implements Serializable {
    public static DataSource QCMySql = null;
    public static DataSource YFBMySql = null;
    public static DataSource JYJMySql = null;
    public static DataSource JYJExternalMySql = null;
    public static DataSource LXJMySql = null;
    static {
        try {
            Properties props = new Properties(); // 创建属性对象
            props.setProperty("initialSize", "20"); //初始化大小
            props.setProperty("maxActive", "100"); //最大连接
            props.setProperty("minIdle", "10");  //最小连接
            props.setProperty("maxWait", "60000"); //等待时长
            props.setProperty("timeBetweenEvictionRunsMillis", "2000");//配置多久进行一次检测,检测需要关闭的连接 单位毫秒
            props.setProperty("minEvictableIdleTimeMillis", "600000");//配置连接在连接池中最小生存时间 单位毫秒
            props.setProperty("maxEvictableIdleTimeMillis", "900000"); //配置连接在连接池中最大生存时间 单位毫秒
            props.setProperty("validationQuery", "select 1");
            props.setProperty("testWhileIdle", "true");
            props.setProperty("testOnBorrow", "false");
            props.setProperty("testOnReturn", "false");
            props.setProperty("keepAlive", "true");
            props.setProperty("phyMaxUseCount", "100000");
            props.setProperty("removeAbandoned", "true");
            props.setProperty("removeAbandonedTimeout", "300");
            props.setProperty("logAbandoned", "false");
            // QC环境
            props.setProperty("url", ConfigurationManager.getProperties(QC_MYSQL_URL));
            props.setProperty("username", ConfigurationManager.getProperties(QC_MYSQL_USER));
            props.setProperty("password", ConfigurationManager.getProperties(QC_MYSQL_PASSWD));
            QCMySql = DruidDataSourceFactory.createDataSource(props);
            // 预发布环境
            props.setProperty("url", ConfigurationManager.getProperties(YFB_MYSQL_URL));
            props.setProperty("username", ConfigurationManager.getProperties(YFB_MYSQL_USER));
            props.setProperty("password", ConfigurationManager.getProperties(YFB_MYSQL_PASSWD));
            YFBMySql = DruidDataSourceFactory.createDataSource(props);
            props.setProperty("url", ConfigurationManager.getProperties(JYJ_MYSQL_URL));
            props.setProperty("username", ConfigurationManager.getProperties(JYJ_MYSQL_USER));
            props.setProperty("password", ConfigurationManager.getProperties(JYJ_MYSQL_PASSWD));
            JYJMySql = DruidDataSourceFactory.createDataSource(props);
            props.setProperty("url", ConfigurationManager.getProperties(JYJ_MYSQL_EXTERNAL_URL));
            props.setProperty("username", ConfigurationManager.getProperties(JYJ_MYSQL_EXTERNAL_USER));
            props.setProperty("password", ConfigurationManager.getProperties(JYJ_MYSQL_EXTERNAL_PASSWD));
            JYJExternalMySql = DruidDataSourceFactory.createDataSource(props);
            props.setProperty("url", ConfigurationManager.getProperties(LXJ_MYSQL_URL));
            props.setProperty("username", ConfigurationManager.getProperties(LXJ_MYSQL_USER));
            props.setProperty("password", ConfigurationManager.getProperties(LXJ_MYSQL_PASSWD));
            LXJMySql = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提供获取连接的方法
    public static Connection getConnection(String env) throws SQLException {
        if ("QC".equals(env)) {
            return QCMySql.getConnection();
        } else if ("YFB".equals(env)) {
            return YFBMySql.getConnection();
        } else if ("JYJ".equals(env)) {
            return JYJMySql.getConnection();
        } else if ("JYJ_EXTERNAL".equals(env)) {
            return JYJExternalMySql.getConnection();
        } else {
            return LXJMySql.getConnection();
        }
    }

    // 提供关闭资源的方法【connection是归还到连接池】
    // 提供关闭资源的方法 【方法重载】3 dql
    public static void closeResource(ResultSet resultSet, PreparedStatement preparedStatement,
                                     Connection connection) {
        // 关闭结果集
        // ctrl+alt+m 将java语句抽取成方法
        closeResultSet(resultSet);
        // 关闭语句执行者
        closePrepareStatement(preparedStatement);
        // 关闭连接
        closeConnection(connection);
    }

    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closePrepareStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
