package com.dxh.demo2war;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(/*exclude = {ErrorMvcAutoConfiguration.class},*/
        scanBasePackages = {"com.dxh.demo2war.mts"})
//@EnableTransactionManagement
//@MapperScan(value = {"com.dxh.demo2war.mts.mapper.*"})
//@ServletComponentScan(basePackages = {"com.dxh.demo2war.pts"}) //使用scan扫描带@WebFilter等的类
@EnableSwagger2
public class Demo2warApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Demo2warApplication.class).bannerMode(Banner.Mode.OFF);
    }

}
