package com.project_01.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project_01.service.CheckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author GyuanYuan Cai
 * 2021/7/25
 * Description:
 */
@WebServlet("/CheckServelt")
// 在这里开tomcat
//localhost:8080/ajax_project/CheckServlet?username=zhangsan
public class CheckServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1.编码设置
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");
            //2.接收参数用户名
            String username = req.getParameter("username");
            //3.创建service,并代用service的查询方法 ==>
            CheckServiceImpl service = new CheckServiceImpl();
            boolean flag = service.daoCheck(username);
            //4.创建一个Map对象 给map中设置内容
            HashMap<String, Object> map = new HashMap<>();
            if (flag) {
                map.put("isExist", true);
                map.put("msg", "该用户已存在，请更换");
            } else {
                map.put("isExist", false);
                map.put("msg", "该用户名可以使用");
            }

            //5.将map转换成json
            ObjectMapper om = new ObjectMapper();
            String mapJson = om.writeValueAsString(map);

            //6.json返回给前台
            resp.getWriter().print(mapJson);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}