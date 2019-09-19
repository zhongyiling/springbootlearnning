package com.zyl.springboot04.controller;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //private Object String;
    //private java.lang.Object Object;

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            // 登录成功
            // return "dashboard";
//            给登录成功的用户生成session，然后拦截请求，验证session
            session.setAttribute("loginUser",username);
            // 登录成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else {
            //  登录失败
            map.put("errMsg","用户名密码错误");
            return "login";
        }


    }
}
