package com.zyl.springboot04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 创建一个监听Servlet创建和销毁的Listener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...Web application starup");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...当前web项目销毁");
    }
}
