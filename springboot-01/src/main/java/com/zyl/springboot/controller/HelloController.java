package com.zyl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// @Controller+@ResponseBody=RestController
@RestController
// @Controller
public class HelloController {
    // 表示返回值在responsebody中
    // @ResponseBody
    // 接收来自浏览器的hello请求
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello world!";
    }
}

