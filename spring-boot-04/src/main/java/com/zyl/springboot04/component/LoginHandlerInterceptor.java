package com.zyl.springboot04.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 此时需要添加拦截器拦截登录请求并且生产LoginHandlerInterceptor
// LoginHandlerInterceptor在LoginController中生成
/**
 * 1.配置拦截器拦截请求--WebMvcConfigurer，
 * 2.
 * */

public class LoginHandlerInterceptor implements HandlerInterceptor {
/*    预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；*/
    //目标方法执行之前，拦截请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 1.从请求中取出session的值，判断session是否正确
         * 2.
         * */
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            //未登录，返回登录页面
            request.setAttribute("responseMsg","没有权限请先登录");
            request.getRequestDispatcher("login.html").forward(request,response);
            return false;
        }else{
            //已登录，放行请求
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
/**HandlerInterceptor
 * 应用场景
 * 1、日志记录，可以记录请求信息的日志，以便进行信息监控、信息统计等。
 * 2、权限检查：如登陆检测，进入处理器检测是否登陆，如果没有直接返回到登陆页面。
 * 3、性能监控：典型的是慢日志。
 * */
