package com.javaweb.mysql.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/7/18
 * Description:
 */

public class $07_XMLJDBCUtils {

    //1.定义字符串变量保存连接信息
    public static String DRIVERNAME;
    public static String URL;
    public static String USER;
    public static String PASSWORD;


    // 静态代码块
    static {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("D:\\code\\studycode_space\\01_java\\src\\main\\java\\com\\javaweb\\mysql\\xml\\$06_jdbc-config.xml");
            // 获取驱动
            Node node1 = document.selectSingleNode("jdbc/property[@name='driverClass']");
            DRIVERNAME = node1.getText();

            Node node2 = document.selectSingleNode("jdbc/property[@name='jdbcUrl']");
            URL = node2.getText();

            Node node3 = document.selectSingleNode("jdbc/property[@name='user']");
            USER = node3.getText();

            Node node4 = document.selectSingleNode("jdbc/property[@name='password']");
            PASSWORD = node4.getText();

            // 注册驱动
            Class.forName(DRIVERNAME);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}