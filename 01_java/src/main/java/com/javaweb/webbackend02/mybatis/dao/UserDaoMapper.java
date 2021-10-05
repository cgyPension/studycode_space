package com.javaweb.webbackend02.mybatis.dao;

import com.javaweb.webbackend02.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

/**
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
 *
 *
 * 使用代理开发模式 要遵循一定的规则：
 * 要在资源里面创建同包同名
 * mapper映射文件也要和映射接口同名
 *
 * Mapper.xml射文件中namespace与mapper接口全限定名相同
 * Mapper接口方法名和Mapper.xml映射文件中定义的每个statement的id相同
 * Mapper接口方法的输入参数类型和mapper.xml映射文件中定义的每个sq的parameterType的类型相同
 * Mapper接口方法的输出参数类型和mapper.xml映射文件中定义的每个sql的resultType的类型相同
 *
 */
public interface UserDaoMapper {

    // 查询所有用户
    public List<User> selectAllResultMap() throws IOException;

    //  根据id查询
    public User selectId(int id) throws IOException;

    //  多条件查询 方式一
    public List<User> selectSexAndAddress(String sex,String address) throws IOException;

    //  多条件查询 方式二
    public List<User> selectIdAndAddress(@Param("id") int id, @Param("address") String address) throws IOException;

    //  多条件查询 方式三 推荐
    public List<User> selectIdAndAddress3(User user) throws IOException;

    //  模糊查询 方式一
    public List<User> selectUsernameLike(String username) throws IOException;

    //  模糊查询 方式二
    public List<User> selectUsernameLike2(String username) throws IOException;

    //  添加用户获取返回主键：方式一
    public void insertUser (User user) throws IOException;

    //  添加用户获取返回主键：方式二
    public void insertUser2 (User user) throws IOException;

    // 在where参数个数不确定的情况下, 可以先拼接 1=1 后面再拼接 and 参数= 可以解决很多问题
    // 动态sql的if标签：多条件查询
    public List<User> selectIdAndUsernameIf(User user) throws IOException;

    // 动态sql的set标签：动态更新
    public void updateIf(User user) throws IOException;

    // 动态sql的foreach标签:多值查询 (集合) :根据多个id值查询用户
    public List<User> selectIdsList(List<Integer> ids) throws IOException;

    // 动态sql的foreach标签:多值查询 (数组) :根据多个id值查询用户
    public List<User> selectIdsArray(Integer[] ids) throws IOException;

}
