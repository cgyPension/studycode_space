package com.javaweb.webbackend02.spring05AOP;


import com.javaweb.webbackend02.spring05AOP.config.SpringConfig;
import com.javaweb.webbackend02.spring05AOP.proxy.CglibProxyFactory;
import com.javaweb.webbackend02.spring05AOP.proxy.JDKProxyFactory;
import com.javaweb.webbackend02.spring05AOP.service.AccountService;
import com.javaweb.webbackend02.spring05AOP.utils.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author GyuanYuan Cai
 * 2021/9/28
 * Description:
 *
 *
 *
 * TODO 完全去除applicationContext.xml文件 纯注解开发
 *
 * Proxy优化转账案例
 * 我们可以将业务代码和事务代码进行拆分,通过动态代理的方式,对业务方法进行事务的增强。这样就不会对业务层产生影响,解决了耦合性的问题啦!
 * 常用的动态代理技术
 * JDK代理:基于接口的动态代理技术:利用拦截器(必须实现invocationHandler)加上反射机制生成一个代理接口的匿名类,在调用具体方法前调用InvokeHandler来处理,从而实现方法增强
 * CGLIB代理:基于父类的动态代理技术:动态生成一个要代理的子类,子类重写要代理的类的所有不是inal的方法。在子类中采用方法拦截技术拦截所有的父类方法的调用,顺势织入横切逻辑,对方法进行增强
 *
 *
 * AOP为Aspect Oriented Programming的缩写,意思为 面向切面编程
 * AOP是OOP (面向对象编程)的延续,是软件开发中的一个热点,也是pring框架中的一个重要内容,利用AOP可以对业务逻辑的各个部分进行隔离,从而使得业务逻辑各部分之间的耦合度降低,提高程序的可重用性,同时提高了开发的效率。
 *
 * 这样做的好处是:
 * 1,在程序运行期间,在不修改源码的情况下对方法进行功能增强
 * 2.逻辑清晰,开发核心业务的时候,不必关注增强业务的代码
 * 3减少重复代码,提高开发效率,便于后期维护
 *
 * 实际上, AOP的底层是通过Spring提供的的动态代理技术实现的。在运行期间, Spring通过动态代理技术动态的生成代理对象,代理对象方法执行时进行增强功能的介入,在去调用目标对象的方法,从而完成功能的增强。
 *
 * AОPH关术语
 * Target (目标对象) :代理的目标对象
 * proxy (代理) :一个类被AOP织入增强后,就产生一个结果代理类
 * Joinpoint (连接点) :所谓连接点是指那些可以被拦截到的点。在spring中,这些点指的是方法,因为spring只支持方法类型的连接点
 * pointcut (切入点) :所谓切入点是指我们要对哪些Joinpoint进行拦截的定义
 * Advice (通知/增强) :所谓通知是指拦截到Joinpoint之后所要做的事情就是通知分类:前置通知、后置通知、异常通知、最终通知、环绕通知
 * Aspect (切面) :是切入点和通知(引价)的结合
 * Weaving (织入) :是指把增强应用到目标对象来创建新的代理对象的过程。spring采用动态代理织入,而Aspectj采用编译期织入和类装载期织入
 */
@RunWith(SpringJUnit4ClassRunner.class) // @RunWith指定juint的运行环境 SpringJUnit4ClassRunner是spring提供的juint运行环境的类
@ContextConfiguration(classes={SpringConfig.class})
public class $01_Spring_AOP_anno {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JDKProxyFactory proxyFactory;

    @Autowired
    private CglibProxyFactory cglibProxyFactory;

    @Test
    public void testTransfer(){
        accountService.transfer("jane","cgy",100d);
    }

    @Test
    public void testTransferProxyJDK(){
        //当前返回的实际上是AccountService的代理对象proxy
        AccountService accountServiceJDKProxy = proxyFactory.createAccountServiceJDKProxy();
        //代理对象proxy调用接口中的任意方法时,都会执行底层的invoke方
        accountServiceJDKProxy.transfer("jane","cgy",100d);
    }

    @Test
    public void testTransferProxyCglib(){
        //当前返回的实际上是AccountService的代理对象proxy
        AccountService accountServiceCglibProxy = cglibProxyFactory.createAccountServiceCglibProxy();
        //代理对象proxy调用接口中的任意方法时,都会执行底层的invoke方
        accountServiceCglibProxy.transfer("jane","cgy",100d);
    }

    // 转账方法切入点添加上事务控制的效果
    @Test
    public void testTransferAOP(){
        accountService.transfer("jane","cgy",100d);
    }
}