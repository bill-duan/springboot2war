package com.dxh.demo2war.pts.config;

import com.dxh.demo2war.pts.filter.LoginFilter;
import com.dxh.demo2war.pts.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean sessionFilterRegister(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new SessionFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.setName("sessionFilter");
        filterBean.setEnabled(true);
        filterBean.setOrder(10);
        return filterBean;
    }

    @Bean
    public FilterRegistrationBean loginFilterRegister(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new LoginFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.setName("loginFilter");
        filterBean.setEnabled(true);
        filterBean.setOrder(5);
        return filterBean;
    }

}
