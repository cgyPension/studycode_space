package com.javaweb.webbackend01;

import jakarta.servlet.ServletConfig;
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
 */

public class $14_CountServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 向servletContext域中存入变量count，并且初始化为0
        this.getServletContext().setAttribute("count",0);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");

        // 向页面响应信息
        resp.getWriter().write("<h1>个人博客</h1>");


        // 进行servletContext域中的取值 取 加 存 0
        Integer count = (Integer) this.getServletContext().getAttribute("count");

        // 加
        count++;

        resp.getWriter().write("<dev>你是，第"+count+"位访问此网站的人</dev>");

        // 存
        this.getServletContext().setAttribute("count",count);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}