package com.cgy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GyuanYuan Cai
 * 2021/10/6
 * Description:
 *
 * Spring MVC的拦截器类似于Servlet开发中的过滤器Filter,用于对处理器进行预处理和后处理。
 * 将拦截器按一定的顺序联结成一条链,这条链称为拦截器链(InterceptorChain) 。在访问被拦截的方法或字段时,拦截器链中的拦截器就会按其之前定义的顺序被调用。拦截器也是AOP思想的具体实现1
 *
 * 区别
 * 过滤器拦截器使用范围是servlet规范中的一部分,任何Java Web工程都可以使用
 * 在url-pattern中配置了/*之后,可以对所有要访问的资源拦截
 *
 * 拦截器
 * 是SpringMVC框架自己的,只有使用了SpringMVC框架的工程才能用拦截范围
 * 只会拦截访问的控制器方法,如果访问的是jsp.html.css.image或者js是不会进行拦截的
 *
 *
 * 执行顺序
 * preHandle1...
 * preHandle2...
 * 目标方法执行了...
 * postHandle2...
 * postHandle1...
 * 视图执行了...
 * afterCompletion2...
 * afterCompletion1...
 */

public class MyInterceptor01 implements HandlerInterceptor {

    // preHandle: 在目标方法执行之前进行拦截   return false; 不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle01...");
        return true;
    }

    // postHandle:在目标方法执行之后,视图对象返回之前,执行的方法 即 return "success";之前的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle01...");
    }

    // afterCompletion:在流程部执行完成后,执行的方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion01...");

    }
}