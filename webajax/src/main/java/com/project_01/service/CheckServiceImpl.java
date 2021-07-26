package com.project_01.service;

import com.project_01.dao.CheckrService;
import com.project_01.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author GyuanYuan Cai
 * 2021/7/25
 * Description:
 */

public class CheckServiceImpl implements CheckrService {
    // 检查用户名是否存在的方法
    @Override
    public boolean daoCheck(String name) throws SQLException {
        DataSource dataSource = JDBCUtils.getDataSource();

        // 使用DBUTILS
        QueryRunner qr = new QueryRunner(dataSource);

        Long count = (Long) qr.query("select count(*) from user where username = ?", new ScalarHandler(), name);

        // 如果查到
        return count >= 1;
    }

}