package com.javaweb.webbackend01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 *
 * ServletContext对象
 *主要作用
 * 1.域对象(共享数据)
 * 2.获取资源在服务器的真实地址
 * 3.获取全局的配置参数
 * 4.获取文件MIME类型
 *
 * 获取ServletContext对象
 * 1,通过request对象获得ServletContext sc = request.getServltContext();
 * 2.继承HttpServlet后,可以直接调用ServletContext sc = this.getServletContext();
 *
 *
 * ServletContext域对象(共享数据)·在当前项目范围内,共享数据(多个servlet都可以获取)
 */

public class $11_OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //向servletContext域对象中存入数据
        ServletContext sc = request.getServletContext();
        sc.setAttribute("user","jack");
        System.out.println("OneServlet中存入了数据...");

        //servletContext获取全局配置参数
        String encode = sc.getInitParameter("encode");
        System.out.println("获取到的全局配置参数"+encode);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}