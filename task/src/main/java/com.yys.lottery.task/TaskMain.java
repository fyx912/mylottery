package com.yys.lottery.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.SpringServletContainerInitializer;


@EnableAutoConfiguration
@MapperScan(basePackages = {"com.yys.lottery.*.mapper.*"})
@ComponentScan(basePackages = {"com.yys.*"})
@EnableScheduling
@SpringBootApplication
public class TaskMain extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(TaskMain.class);
        return super.configure(builder);
    }

    public static void main(String[] args){
        SpringApplication.run(TaskMain.class,args);
    }
}
