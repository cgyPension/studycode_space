package com.javaweb.webbackend01;

import jakarta.servlet.ServletContext;
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

public class $12_TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //向servletContext中取出数据
        ServletContext sc = request.getServletContext();
        String user = (String) sc.getAttribute("user");
        System.out.println("TwoServlet中取出的数据为"+user);

        // 获取lagou.jpg文件的真实路径 在idea显示下是在web文件夹下
        String realPath = sc.getRealPath("/img/lagou.jgp");
        System.out.println(realPath);// D:\servlet_code\servlet_demo\out\artifacts\servlet_demo_war_exploded\img\lagou.jpg
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}