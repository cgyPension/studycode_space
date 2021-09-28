package com.javaweb.webbackend02;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaweb.webbackend02.bean.User;
import com.javaweb.webbackend02.dao.UserDaoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/9/19
 * Description:
 *
 *
 */

public class $03_MyBatisProxy {
    public static void main(String[] args) throws IOException {
        // 代理开发模式
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserDaoMapper多产生的代理对象：底层：JDK动态代理 实际类型: proxy
        // 代理对象是怎么产生的? :底层就是基于JDK动态代理产生的代理对象
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = mapper.selectId(1);

        System.out.println(user);


        // Todo 多条件查询 方式一
        List<User> users = mapper.selectSexAndAddress("女", "广州");
        for (User user1 : users) {
            System.out.println(user1);
        }

        // Todo 多条件查询 方式三
        User user1 = new User();
        user1.setId(3);
        user1.setAddress("湛江");

        List<User> users1 = mapper.selectIdAndAddress3(user1);
        for (User user2 : users1) {
            System.out.println(user2);
        }


        // Todo 模糊查询 方式一
        List<User> users2 = mapper.selectUsernameLike("%张%");
        for (User user3 : users) {
            System.out.println(user3);
        }

        //  Todo 添加用户获取返回主键：方式一
        User user2 = new User();
        user2.setUsername("王冰冰");
        user2.setSex("女");

        System.out.println(user2);
        mapper.insertUser(user2);
        System.out.println(user2);

        // Todo 动态sql的if标签：多条件查询
        User user3 = new User();
        user3.setId(1);
        List<User> usernames = mapper.selectIdAndUsernameIf(user3);
        for (User username : usernames) {
            System.out.println(username);
        }

        // Todo 动态sql的set标签：动态更新
        User user4 = new User();
        user4.setId(1);
        user4.setUsername("你最帅");
        user4.setAddress("乌托邦");
        mapper.updateIf(user4);

        // TODO 动态sql的foreach标签:多值查询 （集合）:根据多个id值查询用户
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(6);

        List<User> users3 = mapper.selectIdsList(ids);
        for (User user5 : users3) {
            System.out.println(user5);
        }

        // TODO 动态sql的foreach标签:多值查询 （数组）:根据多个id值查询用户
        Integer[] ids2 = {2,6,4};

        List<User> users4 = mapper.selectIdsArray(ids2);
        for (User user5 : users4) {
            System.out.println(user5);
        }

        // TODO 核心配置文件深入: plugin标签: pageHeLper
        //设置分页参数
        //参数1: 当前页
        //参数2: 每页显示的条数
        PageHelper.startPage(1,2);

        List<User> users5 = mapper.selectAllResultMap();
        for (User user5 : users5) {
            System.out.println(user5);
        }
        //获取分页相关的其他参数
        PageInfo<User> userPageInfo = new PageInfo<>(users5);
        System.out.println("总条数："+userPageInfo.getTotal());
        System.out.println("总页数："+userPageInfo.getPages());
        System.out.println("是否是第一页："+userPageInfo.isIsFirstPage());


        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

}