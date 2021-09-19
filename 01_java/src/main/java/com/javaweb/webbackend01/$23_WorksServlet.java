package com.javaweb.webbackend01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 */

public class $23_WorksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");*/
        // 1,获取表单中的留言信息(获取请求参数)
        String content = request.getParameter("content");
        // 2.将请求参数的值输出到浏览器
        resp.getWriter().write(content);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}