package com.zyl.springboot04;

import com.zyl.springboot04.component.LoginHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
        // (scanBasePackages = "com.zyl.springboot04.*")
public class SpringBoot04Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot04Application.class, args);
    }
//    自定义视图解析器的方式
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }
    private static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

    @Bean
    public LoginHandlerInterceptor loginHandlerInterceptor(){
        return new LoginHandlerInterceptor();
    }
}

