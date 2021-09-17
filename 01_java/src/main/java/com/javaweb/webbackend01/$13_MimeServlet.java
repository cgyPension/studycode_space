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

public class $13_MimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 获取指定文件的mime类型
        // servlet_demo/$13_MimeServlet?fileNamw=1.jpg
        // 获取请求参数
        String fileName = request.getParameter("fileName");

        // 获取文件的mime类型
        String mimeType = request.getServletContext().getMimeType(fileName);
        resp.getWriter().write(fileName+"-----"+mimeType);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}