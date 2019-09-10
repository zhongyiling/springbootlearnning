package com.zyl.springboot04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
// 使用WebMvcConfigurerAdapter来扩展springMVC的功能


/* @EnableWebMvc使用这个配置就是只是用我们自定义的配置
* 验证方法：只剩下http://localhost:9090/zyl可以访问
* */
/*
* @Configuration既保留了所有的自动配置，也能用我们扩展的配置
* 验证方法：除了http://localhost:9090/zyl映射到success页面，其他求求保持原有的自动配置页面。
* */
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        // 浏览器发送 /zyl请求来到success页面
        registry.addViewController("/zyl").setViewName("success");
    }
}
