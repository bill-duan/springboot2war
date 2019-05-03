package com.dxh.demo2war.mts.config;

import com.dxh.demo2war.pts.filter.LoginFilter;
import com.dxh.demo2war.pts.filter.SessionFilter;
import com.dxh.demo2war.pts.filter.SwaggerFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;

/**
 * 此处定义filter配置类，
 * 不再需要ServletComponentScan和webFilter
 */
@Configuration
public class FilterConfig {

    @Value("${swagger.enable:false}")
    private boolean swaggerEnable;

    @Bean
    public FilterRegistrationBean swaggerFilterRegister(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new SwaggerFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.setName("swaggerFilter");
        filterBean.setEnabled(!swaggerEnable);
        filterBean.setOrder(2);
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

}
