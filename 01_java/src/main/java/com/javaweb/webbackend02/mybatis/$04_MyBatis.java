package com.javaweb.webbackend02.mybatis;

import com.javaweb.webbackend02.mybatis.bean.Orders;
import com.javaweb.webbackend02.mybatis.bean.User;
import com.javaweb.webbackend02.mybatis.bean.UserWithOrdersList;
import com.javaweb.webbackend02.mybatis.dao.OrdersDaoMapper;
import com.javaweb.webbackend02.mybatis.dao.UserWithOrdersListDaoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/9/19
 * Description:
 *
 * 一对一配置:使用<resultMap>+<association>做配置,通过column条件,执行select
 * 查询一对多配置:使用<resultMap>+<collection>做配置,通过column条件,执行sel ect查询
 * 多对多配置:使用<resultMap>+<collection>做配置,通过column条件,执行select
 *
 * 查询优点:简化多表查询操作
 * 缺点:执行多次sql语句,浪费数据库性能
 */

public class $04_MyBatis {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersDaoMapper mapper = sqlSession.getMapper(OrdersDaoMapper.class);

        // TODO 一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
        List<Orders> orders = mapper.selectOrdersAllWithUser();
        for (Orders order : orders) {
            System.out.println(order);
        }


        // TODO 一对多查询的需求:查询所有用户,与此同时查询出该用户具有的订单
        UserWithOrdersListDaoMapper mapper1 = sqlSession.getMapper(UserWithOrdersListDaoMapper.class);
        List<User> userwithorderslist = mapper1.selectUserWithOrdersList();
        for (User user : userwithorderslist) {
            System.out.println(user);
        }

        // TODO 多对多关联查询：查询所有的用户,同时还要查询出每个用户所关联的角色信息
        List<User> users = mapper1.selectUserWithRoleList();
        for (User user : users) {
            System.out.println(user);
        }

        // TODO 一对一嵌套查询：查询所有订单，及关联用户信息
        List<Orders> orders1 = mapper.selectOrdersAllWithUser2();
        for (Orders orders2 : orders1) {
            System.out.println(orders2);
        }

        // TODO 一对多嵌套查询 查询所有用户,与此同时查询出该用户具有的订单
        List<UserWithOrdersList> users1 = mapper1.selectUserWithOrdersList2();
        for (UserWithOrdersList user : users1) {
            // 用了lazyLoadTriggerMethods 覆盖延迟加载
            System.out.println(user);

            // 需要用到该用户的订单信息
            System.out.println(user.getOrdersList());
        }


        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

}