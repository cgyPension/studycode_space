package com.javaweb.webbackend01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 */

public class $16_CookieServlet_get extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 1,通过request象,获取到携带所有cookie
        Cookie[] cookies = request.getCookies();

        // 遍历数组
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                //获取的就是cookie的name值
                String name = cookie.getName();
                //获取cookie的value值
                String value = cookie.getValue();

                // 解码
                // value = URLDecoder.decode(value, "UTF-8");
                System.out.println(name+"-------------"+value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}