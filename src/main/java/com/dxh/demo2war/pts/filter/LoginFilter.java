package com.dxh.demo2war.pts.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("login filter init...");
    }

    @Override
    public void destroy() {
        System.out.println("login filter destroy...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("login filter doFilter...");
        chain.doFilter(request, response);
    }

}
