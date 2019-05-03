package com.dxh.demo2war.pts.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SwaggerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse servletResponse = (HttpServletResponse)response;
        String requestURI = servletRequest.getRequestURI();
        System.out.println("requestURI: " + requestURI);
        //  /swagger-ui.html,/webjars,/swagger-resources,/v2/api-docs
        if(requestURI.contains("/swagger-ui.html")
                || requestURI.contains("/webjars")
                || requestURI.contains("/swagger-resources")
                || requestURI.contains("/v2/api-docs")){
            servletResponse.sendRedirect("404");
            return;
        }
        chain.doFilter(request, response);
    }
}
