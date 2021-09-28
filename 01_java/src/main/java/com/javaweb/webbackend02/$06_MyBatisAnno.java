package com.javaweb.webbackend02;

import com.javaweb.webbackend02.bean.Orders;
import com.javaweb.webbackend02.bean.User;
import com.javaweb.webbackend02.bean.UserWithOrdersList;
import com.javaweb.webbackend02.dao.OrdersMapperAnno;
import com.javaweb.webbackend02.dao.UserMapperAnno;
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
 *  Mybatis也可以使用注解开发方式,这样我们就以减少编写Mapper映射文件了(甚至不用创建Mapper.xml映射文件)。
 *  @Insert:实现新增,代替了<insert></insert>
 *  @Delete:实现删除,代替了<delete></delete>
 *  @Update:实现更新,代替了<update><pupdate>
 *  @select:实现查询,代替了<select></select>
 *  @Result:实现结果集封装,代替了<resultx</result>
 *  @Results:可以与@Result一起使用,封装多个结果集,代替了<resultMap></resultMap>
 *  @one:实现一对一结果集封装,代替了<association></association>
 *  @Many:实现一对多结果集封装,代替了<collectionx</collection>
 *
 *  注解开发和xm1配置优劣分析.
 *  1,注解开发和xm1配置相比,从开发效率来说,注解编写更简单,效率更高。
 *  2·从可维护性来说,注解如果要修改,必须修改源码,会导致维护成本增加。xm1维护性更强。
 */

public class $06_MyBatisAnno {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // TODO 查询所有用户
        UserMapperAnno userMapper = sqlSession.getMapper(UserMapperAnno.class);
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

        // TODO 一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
        OrdersMapperAnno ordersMapper = sqlSession.getMapper(OrdersMapperAnno.class);
        List<Orders> orders = ordersMapper.selectOrdersAllWithUser();
        for (Orders order : orders) {
            System.out.println(order);
        }

        // TODO 一对多嵌套查询 查询所有用户,与此同时查询出该用户具有的订单
        List<UserWithOrdersList> userWithOrdersLists = userMapper.selectUserWithOrdersList();
        for (UserWithOrdersList userWithOrdersList : userWithOrdersLists) {
            System.out.println(userWithOrdersList);
        }

        // TODO 多对多嵌套查询 查询用户同时查询出该用户的所有角色
        List<UserWithOrdersList> usersWithRoles = userMapper.selectUserWithRoleList();
        for (UserWithOrdersList usersWithRole : usersWithRoles) {
            System.out.println(usersWithRole);
            System.out.println(usersWithRole.getRoleList());
        }

        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

}