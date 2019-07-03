package com.cheer.SpringMVC.thymeleaf.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 编码过滤器 采用注解的方式设置路径和参数
 *
 * @author D丨C
 *
 */
@WebFilter(urlPatterns = "/*", initParams = { @WebInitParam(name = "CharsetEncoding", value = "utf-8") })
public class CharacterEncodingFilter implements Filter {

    private static String encoding; // 定义变量接收初始化的值

    public CharacterEncodingFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 设置字符编码
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);

        chain.doFilter(req, resp);
    }

    // 初始化
    public void init(FilterConfig config) throws ServletException {
        //接收注解中的配置参数
        encoding = "UTF-8";
    }

}
