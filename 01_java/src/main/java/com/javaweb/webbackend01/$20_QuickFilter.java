package com.javaweb.webbackend01;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Description;

import java.io.IOException;
import java.util.zip.ZipEntry;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 */


public class $20_QuickFilter implements Filter {

    /**
     * 初始化方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
    * @Author:cgy
    * @Description:
    * @params: null
    * @return: null
    * @Date: 11:48 2021/9/17
    */
    @Override
    public void destroy() {

    }


    /**
     * 拦截用户请求方法
     * @param servletRequest 请求对象
     * @param servletResponse 响应对象
     * @param filterChain  过滤链（是否放行）
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截了请求...");

        // 放行状态
        filterChain.doFilter(servletRequest,servletResponse);
    }
}