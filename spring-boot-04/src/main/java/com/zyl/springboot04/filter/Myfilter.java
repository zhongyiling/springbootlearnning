package com.zyl.springboot04.filter;


import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter process");
    }
    @Override
    public void destroy() {

    }


}
