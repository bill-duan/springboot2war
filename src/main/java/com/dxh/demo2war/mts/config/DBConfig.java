package com.dxh.demo2war.mts.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.druid.initialSize}")
    private String initialSize;
    @Value("${spring.druid.minIdle}")
    private String minIdle;
    @Value("${spring.druid.maxActive}")
    private String maxActive;
    @Value("${spring.druid.maxWait}")
    private String maxWait;
    @Value("${spring.druid.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;
    @Value("${spring.druid.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;
    @Value("${spring.druid.validationQuery}")
    private String validationQuery;
    @Value("${spring.druid.testWhileIdle}")
    private String testWhileIdle;
    @Value("${spring.druid.testOnBorrow}")
    private String testOnBorrow;
    @Value("${spring.druid.testOnReturn}")
    private String testOnReturn;
    @Value("${spring.druid.poolPreparedStatements}")
    private String poolPreparedStatements;
    @Value("${spring.druid.maxPoolPreparedStatementPerConnectionSize}")
    private String maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.druid.filters}")
    private String filters;

    /*@Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(Integer.valueOf(initialSize));
        datasource.setMinIdle(Integer.valueOf(minIdle));
        datasource.setMaxActive(Integer.valueOf(maxActive));
        datasource.setMaxWait(Integer.valueOf(maxWait));
        datasource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(timeBetweenEvictionRunsMillis));
        datasource.setMinEvictableIdleTimeMillis(Integer.valueOf(minEvictableIdleTimeMillis));
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(Boolean.valueOf(testWhileIdle));
        datasource.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
        datasource.setTestOnReturn(Boolean.valueOf(testOnReturn));
        datasource.setPoolPreparedStatements(Boolean.valueOf(poolPreparedStatements));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(maxPoolPreparedStatementPerConnectionSize));
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {

        }
        return datasource;
    }*/

}
