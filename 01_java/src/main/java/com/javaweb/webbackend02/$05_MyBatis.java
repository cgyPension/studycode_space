package com.javaweb.webbackend02;

import com.javaweb.webbackend02.bean.Orders;
import com.javaweb.webbackend02.bean.User;
import com.javaweb.webbackend02.dao.OrdersDaoMapper;
import com.javaweb.webbackend02.dao.UserWithOrdersListDaoMapper;
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
 * 延迟加载
 * 就是在需要用到数据时才进行加载,不需要用到数据时就不加载数据。延迟加载也称懒加载。
 * 优点:先从单表查询,需要时再从关联表去关联查询,大大提高数据库性能,因为查询单表要比关联查询多张表速度要快。
 * 缺点:因为只有当需要用到数据时,才会进行数据库查询,这样在大批量数据查询时,因为查询工作也要消耗时间,所以可能造成用户等待时间变长,造成用户体验下降。
 *
 * 在多表中:一对多,多对多:通常情况下采用延迟加载
 * 一对一(多对一) :通常情况下采用立即加载
 *
 * 注意:延迟加载是基于嵌套查询来实现的
 *
 * 局部延迟加载
 * 在association和collection标签中都有一个fetchType属性,通过修改它的值,可以修改局部的加载策略。
 *             fetchType="lazy" :延迟加载策略
 *             fetchType="eager":立即加载策略
 *
 * 大家在配置了延迟加载策略后,发现即使没有调用关联对象的任何方法,但是在你调用当前对象的equals, clone, hashCode, toString方法时也会触发关联对象的查询。
 * 我们可以在配置文件(mybatis-config.xml)中使用lazyLoadTriggerMethods配置项覆盖掉上面四个方法。
 *
 * 全局延迟加载
 *
 * 局部的加载策略优先级高于全局的加戲策略。
 *
 *
 * Mybatis中存分为一级存,二级缓存。
 * 一级缓存是SalISession级别的缓存,是默认开启的· 所以在参数和SQL完全一样的情况下,我们使用同一个SalSession对象调用一个Mapper方法,
 * 往往只执行一次SQL,因为使用SelSession第一次查询后,MyBatis会将其放在缓存中,以后再查询的时候,如果没有声明需要刷新,并且缓存没有超时的情况下,
 * SqISession都会取出当前缓存的数据,而不会再次发送SQL到数据库。
 *
 * 一级缓存是SqlSession范围的缓存,执行SqlSession的C (增加) U (更新) D (删除)操作,或者调用clearCache), commit), close()方法,都会清空缓存
 *
 * 二级缓存是namspace级别(跨sqlSession)的缓存,是默认不开启的
 * 二级缓存的开启需要进行配置,实现二级缓存的时候, MyBatis要求返回的POJO必须是可序列化的(implements Serializable)。也就是要求实现Serializable接口,
 * 配置方法很简单,只需要在映射XML文件配置<cache/>就可以开启二级缓存了 要在statement开启useCache。
 *
 * 只有执行sqlSession.commit或者sqlSession.close,那么一级缓存中内容才会刷新到二级缓存
 * 同样的二级缓存 只要有一个sqlSession对mapper进行了增删改、都会清空二级缓存
 *
 * 注意问题(脏读)mybatis的二级缓存因为是namespace级别,所以在进行多表查询时会产生脏读问题
 * 建议不要使用mybatis的二级缓存
 * 实际开发中，会使用redis来做第三方缓存
 *
 *
 */

public class $05_MyBatis {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersDaoMapper mapper = sqlSession.getMapper(OrdersDaoMapper.class);

        UserWithOrdersListDaoMapper usermapper = sqlSession.getMapper(UserWithOrdersListDaoMapper.class);

        // TODO 验证mybatis中的一级缓存 debug
        User user = usermapper.selectId(1);
        System.out.println(user);


        User user2 = usermapper.selectId(1);
        System.out.println(user2);

        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

}