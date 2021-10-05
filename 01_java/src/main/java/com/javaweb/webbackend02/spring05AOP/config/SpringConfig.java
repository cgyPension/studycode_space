package com.javaweb.webbackend02.spring05AOP.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * @author GyuanYuan Cai
 * 2021/10/2
 * Description:
 */

@Configuration
@ComponentScan("com.javaweb.webbackend02") // 扫描包
@Import(DataSourceConfig.class) // 用于导入其他配置类
public class SpringConfig {
    @Bean("queryRunner")
    public QueryRunner getQueryRunner(@Autowired DataSource dataSource){
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
}