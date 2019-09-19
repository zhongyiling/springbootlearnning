package com.zyl.springboot04.config;

import com.zyl.springboot04.component.LoginHandlerInterceptor;
import com.zyl.springboot04.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
@ComponentScan("com.zyl.springboot04.*")
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        // 浏览器发送 /zyl请求来到success页面
        registry.addViewController("/zyl").setViewName("success");
    }

    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                // 到登录也页面的请求不可拦截
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return webMvcConfigurer;
    }



    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
