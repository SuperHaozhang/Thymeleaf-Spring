package com.cheer.SpringMVC.thymeleaf.config;

import com.cheer.SpringMVC.thymeleaf.filter.CharacterEncodingFilter;
import com.cheer.spring.mybatis.appconfig.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// web应用初始化类
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override // DispatcherServlet 核心servlet 负责处理所有的http请求然后分发给后面的controller
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //配置字符过滤器 方法二
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        return new Filter[] {characterEncodingFilter};
    }
}