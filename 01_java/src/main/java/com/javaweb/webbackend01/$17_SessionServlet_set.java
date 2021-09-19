package com.javaweb.webbackend01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 * 概念: session是基于cookie来实现的来
 *
 * HttpSession session = req.getSession();
 * 进行判断
 * 1·如果用户是第一次访问,表示创建新的session对象,生成编号
 * 2如果用户不是第一次访问,根据浏览器发送请求所携带的编号,找到对应的session对象,如果没到,再创建
 *
 *
 */

public class $17_SessionServlet_set extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 将需要共享的数据存到session中
        // 获取到session对象
        HttpSession session = request.getSession();
        // 通过session对象进行数据存入
        session.setAttribute("name","小兔子");

        System.out.println("已将共享数据存到session中....");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}