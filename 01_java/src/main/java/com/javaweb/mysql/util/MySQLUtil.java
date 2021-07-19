package com.javaweb.mysql.util;


import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

// 从MySQL工具类
public class MySQLUtil {
    /**
     * @param sql               执行的查询语句
     * @param clz               返回的数据类型
     * @param underScoreToCamel 是否将下划线转换为驼峰命名法
     * @param <T>
     * @return
     */
    public static <T> List<T> queryList(String sql, Class<T> clz, boolean underScoreToCamel) {
        Connection conn = null;
        PreparedStatement ps = null; // 动态sql输入 Statement是静态
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn = SqlServerConnection.getConnection("QC");
            //创建数据库操作对象
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            List<T> resultList = new ArrayList<T>();
            while (rs.next()) {
                T obj = clz.newInstance();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnName(i);
                    String propertyName = columnName;
                    if (underScoreToCamel) {
                        //如果指定将下划线转换为驼峰命名法的值为 true，通过guava工具类，将表中的列转换为类属性的驼峰命名法的形式
                        propertyName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName);
                    }

                    BeanUtils.setProperty(obj, propertyName, rs.getObject(i));
                }
                resultList.add(obj);
            }

            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("从MySQL查询数据失败");
        } finally {
            // 释放资源
            SqlServerConnection.closeResource(rs, ps, conn);
        }
    }

    public static void main(String[] args) {
        List<JSONObject> list = queryList("select * from saas_plus_data_realse.ordercommentcontentanalysis", JSONObject.class, true);
        for (JSONObject tableProcess : list) {
            System.out.println(tableProcess);
        }
    }
}
