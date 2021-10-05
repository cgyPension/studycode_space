package com.javaweb.webbackend02.spring04dbutilsanno;

import com.javaweb.webbackend02.spring04dbutilsanno.bean.Account;
import com.javaweb.webbackend02.spring04dbutilsanno.config.SpringConfig;
import com.javaweb.webbackend02.spring04dbutilsanno.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.runner.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author GyuanYuan Cai
 * 2021/9/28
 * Description:
 *
 * 基于Spring的xml配置实现账户的CRUD案例
 *
 * @Component       使用在类上用于实例化Bean
 * @Controller      使用在web层类上用于实例化Bean
 * @Service         使用在service层类上用于实例化Bean
 * @Repository      使用在dao层类上用于实例化Bean
 * @Autowired       使用在字段上用于根据类型依赖注入  要是有多个实例会再根据变量名再进行匹配 或者再调用@Qualifier
 * @Qualifier       结合@Autowired-起使用,根据名称进行依赖注入
 * @Resource        相当于@Autowired+@Qualifier,按照名称进行注入
 * @Value           注入普通属性  也能这样获取配置文件属性@Value("${jdbc.driverClassName}") private string driver;
 * @Scope           标注Bean的作用范围
 * @PostConstruct   使用在方法上标注该方法是Bean的初始化方法
 * @PreDestroy      使用在方法上标注该方法是Bean的销毁方法
 *
 * Spring常用注解整合Dbutils
 *
 * @Configuration   用于指定当前类是一个Spring配置类,当创建容器时会从该类上加载注解
 * @Bean    使用在方法上,标注将该方法的返回值存储到Spring容器中
 * @PropertySource      用于加载properties文件中的配置
 * @ComponentScan   用于指定Spring在初始化容器时要扫描的包
 * @Import     用于导入其他配置类
 *
 *
 * TODO 完全去除applicationContext.xml文件 纯注解开发
 */
@RunWith(SpringJUnit4ClassRunner.class) // @RunWith指定juint的运行环境 SpringJUnit4ClassRunner是spring提供的juint运行环境的类
@ContextConfiguration(classes={SpringConfig.class})
public class $01_Spring_crud_anno {

    @Autowired
    private AccountService accountService;


    @Test
    public void test1(){
        // 获取到了spring上下文对象，借助上下文对象可以获取到IOC容器中的bean对象
/*
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 使用上下文对象从IOC容器中获取到了bean对象
        AccountService accountService = (AccountService) annotationConfigApplicationContext.getBean("accountService");
*/

        accountService.selectAll();

        Account account = new Account();
        account.setName("露西");
        account.setMoney(123d);
        accountService.insert(account);
    }
}