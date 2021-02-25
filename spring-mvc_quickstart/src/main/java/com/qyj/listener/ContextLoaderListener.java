package com.qyj.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //通过参数创建ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        //创建ApplicationContext对象
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);

        //将spring的应用上下文对象app存储到servletContext域中
        servletContext.setAttribute("app",app);

        //打印
        System.out.println("spring容器创建完毕!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
