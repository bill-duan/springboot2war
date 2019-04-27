package com.dxh.demo2war.mts.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class ErrorPageInterceptor extends HandlerInterceptorAdapter {

    private static List<Integer> errorCodeList = Arrays.asList(404, 403, 500);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        int status = response.getStatus();
//        System.out.println("------------------ " + status);
//        if(errorCodeList.contains(status)){
//            response.sendRedirect("static/errorpage/" + response.getStatus()+".html");
//            return false;
//        }
        return super.preHandle(request, response, handler);
    }
}
