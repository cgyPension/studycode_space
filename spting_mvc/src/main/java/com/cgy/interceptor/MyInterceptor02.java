package com.cgy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GyuanYuan Cai
 * 2021/10/6
 * Description:
 */

public class MyInterceptor02 implements HandlerInterceptor {

    // preHandle: 在目标方法执行之前进行拦截   return false; 不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle02...");
        return true;
    }

    // postHandle:在目标方法执行之后,视图对象返回之前,执行的方法 即 return "success";之前的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle02...");
    }

    // afterCompletion:在流程部执行完成后,执行的方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion02...");

    }
}