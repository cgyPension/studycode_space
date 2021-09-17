package com.javaweb.webbackend01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 *
 * 重定向：用户访问CServlet后,服务器告诉浏览器重定向到DServlet
 */

public class $09_ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DServlet执行了....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}