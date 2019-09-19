package com.zyl.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
//    @ResponseBody注解表示需要将返回值写入response中，浏览器F12查看网络请求是可以看到该response
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello spring";
    }
/*
* 只要我们把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染
*  即，访问http://localhost:9090/success就可以访问http://localhost:9090/success页面
* */
    @RequestMapping("/success")
//    查出一些数据在页面展示
    public String success(Map<String,Object> map){
        map.put("hello","你好");
//        用于展示th:text与th:utext的区别
        map.put("welcome","<h1>欢迎<h1>");
        map.put("users", Arrays.asList("Allen","Ann","Lily"));
//        classpath://templates//sucess.html
        return "success";
    }
    @RequestMapping("/test")
//    查出一些数据在页面展示
    public String test(){
        return "success";
    }

    // 与config\MyMvcConfig.java中的WebMvcConfigurerAdapter二选一即可
/*    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/

}
