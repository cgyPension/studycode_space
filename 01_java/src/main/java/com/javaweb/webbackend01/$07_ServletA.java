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
 *
 * 生命周期
 * 1,何时创建? 用户发送请求时,创建request
 * 2.何时销毁服务器 返回响应是,销毁request
 * 3·作朋范围?一次请求,包含多次转发
 *
 *  Response对象
 *  7.1概述response对象表示web服务器给浏览器返回的响应信息作用:
 *  开发人员可以使用response对象的方法,设置要返回给浏览器的响应信息
 *
 *  将请求消息封装到request中
 *
 *
 *cc
 */

public class $07_ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 设置解码为UTF-8 ,解决post中文乱码问题
        request.setCharacterEncoding("UTF-8");
        System.out.println("AServlet中功能上执行了");

        // 请求转发到Bservelt string path:写的就是要跳转的资源路径
        // 1 获取到转发器对象
/*        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bSerlvet");

    // 2 借助转发器对象进行真正的请求转发
        requestDispatcher.forward(request,resp);*/

        // 向request域中设置数据
        request.setAttribute("hanbao","香辣鸡腿堡");

        // 链式编程
        request.getRequestDispatcher("/bServlet").forward(request,resp);

}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}