package com.javaweb.webbackend01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 * 请求转发
 * 一种在服务器内部的资源跳转方式
 *
 * 请求转发特点
 * 浏览器:发了一次请求
 * 地址栏:没有发生改变
 * 只能转发到服务器内部资源.
 *xx
 */

public class $07_ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 设置解码为UTF-8 ,解决post中文乱码问题
        request.setCharacterEncoding("UTF-8");
        System.out.println("AServlet中功能上执行了");

        // 请求转发到Bservelt string path:写的就是要跳转的资源路径
        // 1 获取到转发器对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bSerlvet");

        // 2 借助转发器对象进行真正的请求转发
        requestDispatcher.forward(request,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}