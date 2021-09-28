package com.javaweb.webbackend02;

import com.javaweb.webbackend02.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/9/19
 * Description:
 *
 * 框架就是一套规范,既然是规范,你使用这个框架就要遵守这个框架所规定的约束。
 * 框架可以理解为半成品软件,框架做好以后,接下来在它基础上进行开发。
 *
 * 框架为我们封装好了一些冗余,且重用率低的代码。并且使用反射与动态代理机制,将代码实现了通用性,让开发人员把精力专注在核心的业务代码实现上。
 * 比如在使用servlet进行开发时,需要在servlet获取表单的参数 每次都要获取很麻烦,
 * 而框架底层就使用反射1机制和拦截器机制帮助我们获取表单的值,使用jdbc每次做专一些简单的crud的时候都必须写sql,
 * 但使用框架就不需要这么麻烦了,直接调用方法就可以。当然,既然是使用框架,那么还是要遵循其一些规范进行配置
 *
 * Java世界中的框架非常的多,每一个框架都是为了解决某一部分或某些问题而存在的。
 * 下面列出在目前企业中流行的几种框架(一定要注意他们是用来解决哪一层问题的) :
 * 持久层框架:专注于解决数据持久化的框架。常用的有mybatis, hibernate, spring jdbc等等。
 * 表现层框架:专注于解决与用户交互的框架。常见的有struts2. spring mvc等等。
 * 全栈框架:能在各层都给出解决方案的框架。比较著名的就是spring.
 *
 * 我们以企业中最常用的组合为准来学习 Spring + Spring MVC + mybatis (SSM)
 *
 * MyBatis是一个优秀的基于ORM的半自动轻量级持久层框架,它对jdbc的操作数据库的过程进行封装,使开发者只需要关注SQL本身,
 * 而不需要花费精力去处理例如注册驱动、创建connection、创建statement,手动设置参数、结果集检索等jdbc繁杂的过程代码
 *
 * ORM: Object Relational Mapping :对象关系映射
 * O:对象模型：实体对象
 * R:关系型数据库的结构模型:数据库表
 * M:映射:将实体对象与数据库表建立映射关系
 *
 *
 */

public class $02_MyBatis {
    public static void main(String[] args) throws IOException {
        // 传统开发模式
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获取sqlSession会话对象 参数填true为自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql参数: statementid : namespace.id
        // Todo 查询操作
        List<User> users = sqlSession.selectList("test.user_selectAll");

        // 遍历打印结果
        for (User user : users) {
            System.out.println(user);
        }

        // Todo 插入操作
        User user = new User();
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广东佛山");

        sqlSession.insert("test.user_insert",user);

        // Todo 更新操作
        User user1 = new User();
        user1.setId(4);
        user1.setUsername("lucy");
        user1.setBirthday(new Date());
        user1.setSex("女");
        user1.setAddress("广东湛江");

        sqlSession.update("test.user_update",user1);

        // Todo 删除操作
        sqlSession.delete("test.user_delete",4);

        // 手动提交事务 不然数据插入不了
        // 增删改涉及数据库数据变化 所以要使用sqlsession对象显示的提交事务
        sqlSession.commit();

        // 关闭资源
        sqlSession.close();
    }

}