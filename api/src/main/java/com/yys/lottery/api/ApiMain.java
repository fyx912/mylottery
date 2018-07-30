package com.yys.lottery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@ServletComponentScan
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.yys.*"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(ApiMain.class);
        return super.configure(builder);
    }

    public static void main(String[] args){
        SpringApplication.run(ApiMain.class,args);
    }
}
