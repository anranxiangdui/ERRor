package com.xy.kfmb.common.filet;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "demoFilter",urlPatterns = "/**")
@Configuration
public class CustomizeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        /*Filter的创建和销毁由WEB服务器负责。*/
        System.out.println("Filter过滤器开始创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            System.out.println("Filter------>过滤请求开始");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Filter------>过滤请求结束");
        } catch (Exception e) {
            System.out.println("Filter------>全局异常拦截,不再向上抛");
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        /*Filter的创建和销毁由WEB服务器负责。*/
        System.out.println("Filter过滤器销毁");
    }
}