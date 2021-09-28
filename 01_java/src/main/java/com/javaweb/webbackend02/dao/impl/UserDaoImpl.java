package com.javaweb.webbackend02.dao.impl;

import com.javaweb.webbackend02.bean.User;
import com.javaweb.webbackend02.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/9/20
 * Description:
 *
 * new UserDaoImpl() 调用方法
 *
 * mybatis的Dao层传统方式：
 * 1.编写UserMapper接口
 * 2.编写UserMapper实现
 * 3.编写UserMapper.xml
 *
 * 传统方式问题思考:
 * 1.实现类中,存在mybatis模板代码重复
 * 2实现类调用方法时, xml中的sql statement硬编码到java代码中
 * 思考:能否只写接口,不写实现类。只编写接口和Mapper.xml即可?
 * 因为在dao (mapper)的实现类中对sqlsession的使用方式很类似。因此mybatis提供了接口的动态代理。
 *
 * mybatis的Dao层代理开发方式：
 * 1.编写UserMapper接口
 * 2.编写UserMapper.xml
 */

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("test.user_selectAll");
        return users;
    }
}