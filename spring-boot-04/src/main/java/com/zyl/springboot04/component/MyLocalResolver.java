package com.zyl.springboot04.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以再链接上携带区域信息
 * */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String htmlLocale = request.getParameter("locale");
        // 坑：Locale locale = null; 会报错
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(htmlLocale)){
            String[] split = htmlLocale.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
