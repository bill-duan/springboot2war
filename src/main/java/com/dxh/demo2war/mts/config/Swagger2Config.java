package com.dxh.demo2war.mts.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        Predicate<String> paths = PathSelectors.any();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("test a swagger api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dxh.demo2war.mts.controller"))
                .paths(paths)
                .build();
    }

    private ApiInfo apiInfo(){
        String title = "swagger demo";
        String description = "just for test";
        String version = "1.0";
        String termsOfServiceUrl = "http://127.0.0.1";
        Contact contact = new Contact("test", "http://www.test.com", "test@190.co");
        String license = "free";
        String licenseUrl = "http://localhost";
        Collection<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
        return new ApiInfo(title, description, version, "", null, "",
                "", vendorExtensions);
    }
}
