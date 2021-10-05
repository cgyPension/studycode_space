package com.javaweb.webbackend02.spring05AOP.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author GyuanYuan Cai
 * 2021/10/4
 * Description:
 *
 * XML开发：
 * 前置通知
 * 后置通知
 * 异常通知
 * 最终通知
 * 环绕通知<aop:before><aop:afterReturning><aop:afterThrowing><аop:after><aop:around>用于配置前置通知。指定增强的方法在切入点方法之前执行用于配置后置通知。指定增强的方法在切入点方法之后执行用于配置异常通知。指定增强的方法出现异常后执行用于配置最终通知。无论切入点方法执行时是否有异常,都会执行用于配置环绕通知。开发者可以手动控制增强代码在什么时候执行
 *
 *
 *
 * 展示的为注解开发
 *
 * 前置通知 @Before
 * 后置通知 @AfterReturning
 * 异常通知 @AfterThrowing
 * 最终通知 @After
 * 环绕通知 @Around
 *
 * 当前四个通知组合在一起时,执行顺序如下（有bug）:
 * @Before-> @After -> @AfterReturning (如果有异常: @AfterThrowing)
 */
@Component
@Aspect // 升级为切面类 配置切入点和通知关系
public class MyAdvice {
    @Pointcut("execution(* com.javaweb.webbackend02.spring05AOP.service.impl.AccountServiceImpl.transfer())")
    public void myPoint(){}

   /* @Before("MyAdvice.myPoint()")
    *//*@Before("execution(* com.javaweb.webbackend02.spring05AOP.service.impl.AccountServiceImpl.transfer())")*//*
    public void before(){
        System.out.println("前置通知......");
    }

    @AfterReturning("MyAdvice.myPoint()")
   *//* @AfterReturning("execution(* com.javaweb.webbackend02.spring05AOP.service.impl.AccountServiceImpl.transfer())")*//*
    public void after(){
        System.out.println("后置通知......");

    }

    @After("MyAdvice.myPoint()")
    public void finallyInform(){
        System.out.println("最终通知......");
    }

    @AfterThrowing("execution(* com.javaweb.webbackend02.spring05AOP.service.impl.AccountServiceImpl.*(..))")
    public void ThrowingInform(){
        System.out.println("异常通知......");
    }
*/
    @Around("MyAdvice.myPoint()")
    public Object around(ProceedingJoinPoint pjp){
        Object proceed = null;
        try {
            System.out.println("前置通知......");
            proceed = pjp.proceed();
            System.out.println("后置通知......");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知......");
        }finally {
            System.out.println("最终通知......");
        }
        return proceed;
    }
}