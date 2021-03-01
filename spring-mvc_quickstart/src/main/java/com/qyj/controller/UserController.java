package com.qyj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qyj.domain.User;
import com.qyj.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


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

    /**
     * 获得基本类型参数
     * @throws IOException
     */
    @RequestMapping(value="/quick11")
    @ResponseBody
    public void save11(String username, int age) throws IOException{//字符串自动转换数字
        System.out.println("username="+username+"age="+age);
    }

    /**
     * 获得POJO类型参数
     * @throws IOException
     */
    @RequestMapping(value="/quick12")
    @ResponseBody
    public void save12(User user) throws IOException{
        System.out.println(user);
    }


    /**
     * 获得数组类型参数
     * @throws IOException
     */
    @RequestMapping(value="/quick13")
    @ResponseBody
    public void save13(String[] strings) throws IOException{
        System.out.println(Arrays.asList(strings));//转换为集合输出
    }

    /**
     * 获得集合类型参数1
     * @param vo
     * @throws IOException
     */
    @RequestMapping(value="/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException{
        System.out.println(vo);
    }

    /**
     * 获得集合类型参数2
     * @param userList
     * @throws IOException
     */
    @RequestMapping(value="/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException{
        System.out.println(userList);
    }

    /**
     * 参数绑定注解
     * @param username
     * @throws IOException
     */
    @RequestMapping(value="/quick16")
    @ResponseBody
    public void save16(@RequestParam(value="name",required = true,defaultValue = "unname") String username) throws IOException{
        System.out.println(username);
    }

    /**
     * 获得Restful风格的参数
     * @param username
     * @throws IOException
     */
    @RequestMapping(value="/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value="username",required = true) String username) throws IOException{
        System.out.println(username);
    }

    /**
     * 自定义类型转换器
     * @param date
     * @throws IOException
     */
    @RequestMapping(value="/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException{
        System.out.println(date);
    }

    /**
     * 使用原生api
     * @param resp
     * @param req
     * @param session
     * @throws IOException
     */
    @RequestMapping(value="/quick19")
    @ResponseBody
    public void save19(HttpServletResponse resp, HttpServletRequest req, HttpSession session) throws IOException{
        String name = req.getParameter("name");
        System.out.println(name);
        System.out.println(session);
        resp.getWriter().write(name);
    }

    /**
     * 获取请求头信息
     * @param user_agent
     * @throws IOException
     */
    @RequestMapping(value="/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent") String user_agent) throws IOException{
        System.out.println(user_agent);
    }

    /**
     * 获取cookie
     * @param jsessionId
     * @throws IOException
     */
    @RequestMapping(value="/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException{
        System.out.println(jsessionId);
    }

    @RequestMapping(value="/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException{
        System.out.println(username);
        System.out.println(uploadFile);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        //指定保存路径
        uploadFile.transferTo(new File("C:\\Users\\10788\\Desktop\\upload\\"+originalFilename));
    }
}
