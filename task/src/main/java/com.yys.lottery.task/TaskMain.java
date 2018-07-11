package com.yys.lottery.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.SpringServletContainerInitializer;

@EnableCaching
@ServletComponentScan
@EnableAutoConfiguration
@MapperScan({"com.yys.lottery.*","com.yys.lottery.task.mapper.*","com.yys.lottery.core.dao.mapper.*"})
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
