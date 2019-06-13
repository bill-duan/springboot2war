package com.dxh.demo2war.mts.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class ErrorPageInterceptor extends HandlerInterceptorAdapter {

    private static List<Integer> errorCodeList = Arrays.asList(404, 403, 500);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        int status = response.getStatus();
        if(errorCodeList.contains(status)){
            response.sendRedirect("/admin/"+status);
        }
        super.postHandle(request, response, handler, modelAndView);
    }

}
