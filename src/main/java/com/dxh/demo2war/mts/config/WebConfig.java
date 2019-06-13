package com.dxh.demo2war.mts.config;

import com.dxh.demo2war.mts.interceptor.ErrorPageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${spring.pop.nam}")
    private String val;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("val; "+val);
        registry.addInterceptor(new ErrorPageInterceptor());
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");

//    }
}
