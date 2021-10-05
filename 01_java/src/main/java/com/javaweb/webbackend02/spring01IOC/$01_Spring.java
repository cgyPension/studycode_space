package com.javaweb.webbackend02.spring01IOC;

import com.javaweb.webbackend02.spring01IOC.service.impl.UserServiceImpl;

/**
 * @author GyuanYuan Cai
 * 2021/9/28
 * Description:
 *
 * 要用java11
 *
 * Spring是分层的Java SE/EE应用full-stack(全栈式 三层架构都提供了解决方案)轻量级开源框架。
 * 提供了表现层SpringMVC和持久层Spring JDBC Template以及业务层事务管理等众多的企业级应用技术,还能整合开源世界众多著名的第三方框架和类库,
 * 逐渐成为使用最多的Java EE企业应用开源框架。
 * 两大核心:以IOC (Inverse Of Control:控制反转)和AOP (Aspect Oriented Programming:面向切面编程)为内核。
 *
 * IOC:控制反转:把对象的创建权交给spring
 * AOP:面向切面编程:在不修改源代码的情况下,对方法进行增强
 *
 *
 * Spring优势
 * 1)方便解耦,简化开发  【只要看见new,那么就会存在编译期依赖,耦合重的体现解耦思路:去掉new关键字  问题：虽然解决了编译期依赖，但是存在硬编码问题  解耦思路:配置文件+反射】
 *       Spring就是一个容器,可以将所有对象创建和关系维护交给Spring管理什么是耦合度?对象之间的关系,
 *       通常说当一个模块(对象)更改时也需要更改其他模块(对象),这就是耦合,耦合度过高会使代码的维护成本增加。要尽量解耦
 * 2) AOP编程的支持
 *      Spring提供面向切面编程,方便实现程序进行权限拦截,运行监控等功能。
 * 3)声明式事务的支持
 *      通过配置完成事务的管理,无需手动编程
 * 4)方便测试,降低JavaEE API的使用
 *    Spring对Junit4支持,可以使用注解测试
 * 5)方便集成各种优秀框架
 *    不排除各种优秀的开源框架,内部提供了对各种优秀框架的直接支持
 *
 *
 *  传统方式之前我们需要一个userDao实例,需要开发者自己手动创建new UserDao();
 *  IOC方式现在我们需要一个userDao实例,直接从spring的IOC容器获得,对象的创建权交给了spring控制
 *
 *
 *  当前service对象和dao对象耦合度太高,而且每次new的都是一个新的对象,导致服务器压力过大。
 *  解耦合的原则是编译期不依赖而运行期依赖就行了。
 */

// 自定义IOC
public class $01_Spring {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //获取业务层对象
        UserServiceImpl userService = new UserServiceImpl();
        //调用show方法
        userService.show();
    }

}