package com.qyj.web;

import com.qyj.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();

        //通过ServletContext对象获取ApplicationContext对象
        //ApplicationContext app = (ApplicationContext)servletContext.getAttribute("app");
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        //通过spring获取上下文对象
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        //从容器中获取指定Bean
        UserService userService = app.getBean(UserService.class);

        //执行Bean的具体方法
        userService.save();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
