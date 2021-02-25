package com.qyj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qyj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/quick",method = RequestMethod.GET,params = "username")
    public String save(){
        System.out.println("Controller save running");
        return "redirect:/jsp/success.jsp";
    }

    @RequestMapping(value="/quick2")
    public ModelAndView save2(){
        /*
            Model:模型 封装数据
            View: 视图 展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("name","jack");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value="/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("name","jack");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value="/quick4")
    public String save4(Model model){
        model.addAttribute("name","jack");
        return "success";
    }

    @RequestMapping(value="/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("name","jack");
        return "success";
    }

    @RequestMapping(value="/quick6")
    public void save6(HttpServletResponse response) throws IOException {
//        response.getWriter().write("write");
        response.getWriter().print("print");
    }

    @RequestMapping(value="/quick7")
    @ResponseBody
    public String save7(){
        return "print";
    }

    @RequestMapping(value="/quick8")
    @ResponseBody
    public String save8(){
        return "{'name' : 'jack'}";
    }

    @RequestMapping(value="/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("jack");
        user.setAge(20);
        //使用json转换工具将对象转换成json字符串
        ObjectMapper objMapper = new ObjectMapper();
        String json = objMapper.writeValueAsString(user);
        return json;
    }

    //spring自动将bean对象转换为json
    @RequestMapping(value="/quick10")
    @ResponseBody
    public User save10() throws IOException{
        User user = new User();
        user.setUsername("jack");
        user.setAge(10);
        return user;
    }
}
