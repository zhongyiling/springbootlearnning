package com.zyl.springboot04.config;

import com.zyl.springboot04.MyListener;
import com.zyl.springboot04.Servlet.MyServlet;
import com.zyl.springboot04.filter.Myfilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {
    // 注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1); // 设置启动顺序
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Myfilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(new MyListener());
        return registrationBean;
    }
}
