package com.javaweb.webbackend02.spring05AOP.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author GyuanYuan Cai
 * 2021/10/3
 * Description:
 */
@PropertySource("classpath:common.properties") // 加载数据库配置文件
public class DataSourceConfig {
    @Value("${mysql.driver}")
    private String driver;
    @Value("${prod.mysql.url}")
    private String url;
    @Value("${prod.mysql.user}")
    private String username;
    @Value("${prod.mysql.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

}