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
 * 请求转发
 * 一种在服务器内部的资源跳转方式
 *
 *
 * 响应体
 * 1·字符输出流
 * Printwriter getwriter()
 * 2·字节输出流
 * Servletoutputstream getoutputstream()
 * 注意:在同一个servlet中,二种类型的输出流不能同时存在,互斥
 */

public class $07_ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 设置解码为UTF-8 ,解决post中文乱码问题
        request.setCharacterEncoding("UTF-8");
        System.out.println("BServlet中功能上执行了");

        // 从request域中取出数据 a发过来的
        String hanbao = (String) request.getAttribute("hanbao");
        System.out.println(hanbao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}