package com.javaweb.Spring;

import com.javaweb.Spring.service.UserService;
import com.javaweb.springIOC.dao.UserDao;
import com.javaweb.springIOC.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author GyuanYuan Cai
 * 2021/9/28
 * Description:
 *
 * 要用java11
 *
 * BeanFactory是IOC容器的核心接口,它定义了IOC的基本功能。 特点:在第一次调用getBean()方法时,创建指定对象的实例
 *
 * ApplicationContext 代表应用上下文对象,可以获得spring中IOC容器的Bean对象。在spring容器启动时,加载并创建所有对象的实例
 *
 * Bean依赖注入
 * 构造方法注入
 * set方法注入
 * P命名间注入 本质也是set方法注入,但比起上述的set方法注入更加方便,主要体现在配置文件中,如下: .
 *
 * 上面操作,都是注入Bean对象,除了对象的引用可以注入,普通数据类型和集合都可以在容器中进行注入。
 * 注入数据的三种数据类型*1.i通数据类型2.引用数据类型3,集合数据类型
 *
 * DbUtils是Apache的一款用于简化Dao代码的工具类,它底层封装了JDBC技术。
 */

public class $01_Spring {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //UserServiceImpl userService = new UserServiceImpl();
        // 获取到了spring上下文对象，借助上下文对象可以获取到IOC容器中的bean对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-dao.xml");
        // 使用上下文对象从IOC容器中获取到了bean对象
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

        userService.show();
    }

}