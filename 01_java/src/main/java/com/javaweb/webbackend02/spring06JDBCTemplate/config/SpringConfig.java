package com.javaweb.webbackend02.spring06JDBCTemplate.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author GyuanYuan Cai
 * 2021/10/2
 * Description:
 */

@Configuration
@ComponentScan("com.javaweb.webbackend02") // 扫描包
@Import(DataSourceConfig.class) // 用于导入其他配置类
@EnableTransactionManagement // 事务的注解支持
public class SpringConfig {
    @Bean("JdbcTemplate")
    public JdbcTemplate geJdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    public PlatformTransactionManager getPlatformTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }
}