package com.javaweb.webbackend02.spring04dbutilsanno.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Date;

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