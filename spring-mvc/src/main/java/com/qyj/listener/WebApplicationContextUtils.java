package com.qyj.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * 优化,使业务代码不需要输入app
 */
public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext)servletContext.getAttribute("app");
    }

}
