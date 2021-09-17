package com.javaweb.webbackend01;

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
 */

public class $10_ServletE extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 第一种 设置编码时,一定要写在首行
        // request.setCharacterEncoding("GBK");

        // 第二种 统一浏览器和服务器编码
        resp.setContentType("text/html;charset=utf-8");

        // 向页面输出中文
        PrintWriter writer = resp.getWriter();
        writer.write("中文会不会乱码！！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}