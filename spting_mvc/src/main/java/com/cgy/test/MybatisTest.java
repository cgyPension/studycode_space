package com.cgy.test;

import com.cgy.bean.Account;
import com.cgy.dao.AccountDao;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/24
 * Description:
 *
 * 将mybatis接口代理对象的创建权交给spring管理,我们就可以把dao的代理对象注入到service中,此时也就完成了spring与mybatis的整合了。
 */

public class MybatisTest {

    @Test
        public void testMybatis() throws IOException {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AccountDao mapper = sqlSession.getMapper(AccountDao.class);
            List<Account> accounts = mapper.selectAll();
            for (Account account : accounts) {
                System.out.println(account);
            }
            sqlSession.close();
        }

}