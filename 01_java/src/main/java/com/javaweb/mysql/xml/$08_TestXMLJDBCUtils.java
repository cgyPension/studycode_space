package com.javaweb.mysql.xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author GyuanYuan Cai
 * 2021/7/19
 * Description:
 */

public class $08_TestXMLJDBCUtils {
    public static void main(String[] args) throws SQLException {
        Connection connection = $07_XMLJDBCUtils.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");

        // 处理结果集
        while (resultSet.next()){
            String name = resultSet.getString("ename");
            System.out.println("员工姓名是：" + name);
        }
    }

}