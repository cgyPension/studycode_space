package com.example.webajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
需求:编写一个Servlet ,能够接收用户的请求,还可以给用户返回一些响应
 */
//@WebServlet(name = "/DemoServlet", value = "/demo-servlet")
@WebServlet("/DemoServlet") // /DemoServlet 为资源路径
public class DemoServlet extends HttpServlet {

    //客户端发送get方式的请求，由该方法处理
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    //客户端发送post请求,由doPost方法处理
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("服务器已经接受到客户端的请求....");
        // 接受前端传递的参数
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String age = req.getParameter("age");
        System.out.println("age = " + age);
        //给客户端返回消息
        resp.getWriter().println("hello...");

    }

}