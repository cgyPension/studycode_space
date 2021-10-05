package com.javaweb.webbackend02.spring03IOCcrud;

import com.javaweb.webbackend02.spring03IOCcrud.bean.Account;
import com.javaweb.webbackend02.spring03IOCcrud.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
 * 使用注解进行开发时,需要在applicationContext.xml中配置组件扫描,作用是指定哪个包及其子包下的Bean需要进行扫描以便识别使用注解配置的类、字段和方法。
 */

public class $01_Spring_crud {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //UserServiceImpl userService = new UserServiceImpl();
        // 获取到了spring上下文对象，借助上下文对象可以获取到IOC容器中的bean对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext-crud.xml");
        // 使用上下文对象从IOC容器中获取到了bean对象
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");

        accountService.selectAll();

        Account account = new Account();
        account.setName("露西");
        account.setMoney(123d);
        accountService.insert(account);
    }

}