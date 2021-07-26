package com.project_01.dao;

import com.project_01.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author GyuanYuan Cai
 * 2021/7/25
 * Description: 三层MVC
 */

public interface CheckrService {
    // 检查用户名是否存在的方法
    public boolean daoCheck(String name) throws SQLException;
}