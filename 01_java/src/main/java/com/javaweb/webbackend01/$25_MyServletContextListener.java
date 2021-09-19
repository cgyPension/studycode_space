package com.javaweb.webbackend01;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**

/**
 * @author GyuanYuan Cai
 * 2021/9/19
 * Description:
 *
 * javaweb中的监听器
 * 在我们的java程序中,有时也需要监视某些事情,一旦被监听的对象发生相应的变化,我们应该采取相应的操作。
 * 监听web三大域对象: HttpSerletRequest, HttpSession, ServletContext
 * 通过监听器监听三大域对象它们的创建和销毁
 *
 * 场景
 * 万史访问次数、统计在线人数、系统启动时初始化配置信息
 */

public class $25_MyServletContextListener implements ServletContextListener {

    // 监听servletContext对象创建的方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听servletContext对象创建了...");
    }

    // 监听servletContext对象销毁的方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听servletContext对象销毁了...");
    }
}