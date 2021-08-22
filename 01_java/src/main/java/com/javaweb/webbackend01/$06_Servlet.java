package com.javaweb.webbackend01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 *  url-pattern
 * 1,精确匹配(掌握)/servletDemo3 localhost: 8080/项目路径/servletDemo3
 * 2·目录匹配/aa/*
 * 3.后缀匹配*.xxx 例如: *.do
 *
 * 请求转发
 * 一种在服务器内部的资源跳转方式
 */

public class $06_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 设置解码为UTF-8 ,解决post中文乱码问题
        request.setCharacterEncoding("UTF-8");
        // 获取表单提交的请求参数
        String username = request.getParameter("username");
        System.out.println("用户名："+username);

        // 获取爱好这样的多个value的数组类型
        String[] hobbies = request.getParameterValues("hobby");
/*        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/
        System.out.println(Arrays.toString(hobbies));

        // 获取所有的请求参数的key和value
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k,v)->{
            System.out.println(k+"="+v);
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        中文乱码【重点】
        get:在tomcat8及以上版本,内部URL编码(UTF-8)
        post:编码解码不一致,造成乱码现象客户端(浏览器)编码: UTF-8
        服务器默认 解码: 150-8859-1 拉丁文
        指定解码: void setcharacterEncoding(String env)
        注:这必须在方法内,行首
         */
        doGet(req,resp);
    }
}