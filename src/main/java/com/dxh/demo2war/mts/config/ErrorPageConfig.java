package com.dxh.demo2war.mts.config;

import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){

        ErrorPage error400Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorpage/400.html");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorpage/401.html");
        ErrorPage error403Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errorpage/403.html");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorpage/500.html");
        TomcatServletWebServerFactory tswsf = new TomcatServletWebServerFactory();
        tswsf.addErrorPages(error400Page,error401Page,error403Page,error500Page);

        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){
            @Override
            public void customize(ConfigurableWebServerFactory factory) {

            }
        };
    }
}
