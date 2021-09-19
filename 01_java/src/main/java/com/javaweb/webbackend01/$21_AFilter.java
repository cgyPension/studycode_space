package com.javaweb.webbackend01;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 * 在一次请求中,若我们请求匹配到了多个filter,通过请求就相当于把这些filter串起来了,形成了过滤器链
 */


public class $21_AFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AFilter拦截了请求...");

        // 放行状态
        filterChain.doFilter(servletRequest,servletResponse);

        // 对响应进行增强
        System.out.println("AFilter响应增强...");
    }
}