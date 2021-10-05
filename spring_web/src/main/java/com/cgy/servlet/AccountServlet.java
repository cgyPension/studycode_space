package com.cgy.servlet;

import com.cgy.bean.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

//@javax.servlet.annotation.WebServlet(name = "AccountServlet")
public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // classPathXmlApplicationcontext对象存到seryletContext域中
     /*   ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = (Account) classPathXmlApplicationContext.getBean("account");
        System.out.println(account);*/

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        Account account = (Account) webApplicationContext.getBean("account");
        System.out.println(account);
    }
}
