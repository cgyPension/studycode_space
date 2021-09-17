package com.javaweb.webbackend01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 * B/S架构中:从浏览器第一次给服务器发送请求时,建立会话;直到有一方断开,会话结束
 * http 协议:无状态的协议,同一个会话中的连续的多个请求是相互独立的，彼此互不了解
 * 一次会话:包含多次请求和响应
 *
 * 会话技术:就是存储浏览器和服务器多次请求之间的数据
 *
 *  客户端会话技术: cookie
 *  服务器端会话技术: session
 *
 *
 * Cookie在浏览器保存时间?
 * 默认情况下浏览器关闭(会话结束) , cookie销毁(内存)
 * 设置cookie的存活时间cookie. setMaxAge(int second);--单位是秒
 * 正数:指定存活时间,持久化浏览器的磁盘中,到期后自动销毁
 * 负数：默认浏览器关闭, cookie销毁
 * 零：立即销毁(自杀)
 *
 *
 * 使用Cookie问题
 * 1.最多存储4K字符串
 * 2．存储数据不太安全
 *
 * 概念: session是基于cookie来实现的来
 */

public class $15_CookieServlet_set extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 1,创建cookie对象,设置数据

/*
        单独设置编码
        String encodevalue = URLEncoder.encode( "杰克", "UTF-8");
        Cookie cookie1 = new Cookie("name", encodevalue);*/
        Cookie cookie1 = new Cookie("name", "财神爷");
        Cookie cookie2 = new Cookie("age", "18");

        // 正数存活62秒,过期销毁
        cookie1.setMaxAge(60);

        // 2,通过response对象响应cookie
        resp. addCookie(cookie1);
        resp. addCookie(cookie2);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}