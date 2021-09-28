package com.javaweb.webbackend02.dao;

import com.javaweb.webbackend02.bean.Orders;
import com.javaweb.webbackend02.bean.User;
import com.javaweb.webbackend02.bean.UserWithOrdersList;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.io.IOException;
import java.util.List;

/**
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
 */
@CacheNamespace // 配置文件设置后 这里再配置了二级缓存 不过一般不用二级缓存 会产生脏读
public interface UserMapperAnno {

    // 查询所有用户
    @Select(value = "select * from test.user") // 只用一个参数的时候value可以省略不写
    public List<User> selectAll() throws IOException;

    //  添加用户
    @Insert("insert into test.user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void insertUser (User user) throws IOException;

    // 更新用户
    @Update("update test.user set username = #{username},birthday=#{birthday} where id =#{id}")
    public void updateIf(User user) throws IOException;

    //  删除用户
    @Delete("delete from test.user where id=#{id}")
    public void deleteUser (Integer id) throws IOException;

    // 根据id查询用户 用在order的一对一关联查询
    @Select(value = "select * from test.user where id = #{uid}")
    public User selectAllWhereId() throws IOException;

    // 一对多嵌套查询 查询所有用户,与此同时查询出该用户具有的订单
    @Select("select * from test.user") // 第一次发送的sqi句,查询出用户的全部信息
    @Results({ //代替的就是resultMap标签id标签 result标签
            @Result(property="id",column="id",id = true),
            @Result(property="username",column="username"),
            @Result(property="birthday",column="birthday"),
            @Result(property="sex",column="sex"),
            @Result(property="address",column="address"),
            @Result(property="ordersList",javaType = List.class,column = "id",many = @Many(select = "com.javaweb.webbackend02.dao.OrdersMapperAnno.selectAllWhereUid")),
    })
    public List<UserWithOrdersList> selectUserWithOrdersList() throws IOException;

    // 多对多嵌套查询 查询用户同时查询出该用户的所有角色
    @Select("select * from test.user")
    @Results({ //代替的就是resultMap标签id标签 result标签
            @Result(property="id",column="id",id = true),
            @Result(property="username",column="username"),
            @Result(property="birthday",column="birthday"),
            @Result(property="sex",column="sex"),
            @Result(property="address",column="address"),
            @Result(property="roleList",javaType = List.class,column = "id",many = @Many(select = "com.javaweb.webbackend02.dao.RoleMapperAnno.selectUid")),
    })
    public List<UserWithOrdersList> selectUserWithRoleList() throws IOException;
}
