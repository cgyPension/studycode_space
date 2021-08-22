package com.javaweb.webbackend01;

import com.sun.java.swing.action.NextAction;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import jdk.nashorn.internal.ir.VarNode;
import jdk.vm.ci.meta.Value;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 *  url-pattern
 * 1,精确匹配(掌握)/servletDemo3 localhost: 8080/项目路径/servletDemo3
 * 2·目录匹配/aa/*
 * 3.后缀匹配*.xxx 例如: *.do
 */

public class $05_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("$05_Servlet中的doGet方法执行了...");

        // 演示request对象获取请求行信息
        System.out.println("请求方式："+ request.getMethod());
        System.out.println("虚拟路径："+ request.getContextPath());
        System.out.println("URL："+ request.getRequestURL());
        System.out.println("协议和版本："+ request.getProtocol());
        System.out.println("客户端Ip地址："+ request.getRemoteAddr());


        System.out.println("获取指定的头信息 host："+ request.getHeader("Host"));

        // 获取所有的请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            // 请求头名称
            String name = headerNames.nextElement();
            // 根据名称获取值
            String value = request.getHeader(name);
            System.out.println(name+":"+ value);
        }
        System.out.println("客户端Ip地址："+ request.getRemoteAddr());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("$05_Servlet中的dopost方法执行了...");
        doGet(req,resp);
    }
}