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
 *
 * 重定向特点
 * 1,地址栏会发生改变
 * 2,重定向是二次请求
 * 3,重定向是客户端(浏览器)行为,可以跳转到服务器外部资源...
 * 4·不能使用request域共享数据
 *
 *
 *
 * 请求转发与重定向的区别
 * 1.哪个对象
 * 转发(request对象的方法)
 * request.getRequestDispatcher ("/bServlet"). forward(request, response);
 * 重定向
 * (response对象的方法) 1response.sendRedirect ("/day10_response/bservlet"):
 *
 * 2.几次请求
 * 转发
 * 地址栏:没有改变
 * 浏览器： 发了一次请求
 * 服务器: 只有一对请求和响应对象
 * 发生的位置：服务器
 *
 * 重定向
 * 地址e:发生了改变
 * 浏览器： 发了两次请求
 * 服务器: 有两对请求和响应对象
 * 发生的位置: 浏览器
 *
 * 3.小结
 * 写法
 * 转发("/servlet资源路径")服务器内部行为
 * 重定向("/虚拟路径(项目名) /servlet资源路径")浏览器外部行为
 *
 * 使用场景(重点掌握)
 * 如果需要传递数据(request域) ,使用转发
 * 如果不需要传递数据(request域) ,使用重定向
 */

public class $08_ServletC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问到CServlet,接下来重定向到DServlet");

        // 设置重定向 方式一
/*        resp.setStatus(302);
        resp.setHeader("Location","dServlet");*/

        // 设置重定向 方式二 常用
       // resp. sendRedirect( "https://www.lagou.com/");
        resp.sendRedirect("dServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}