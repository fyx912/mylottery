package com.yys.lottery.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@MapperScan(basePackages = {"com.yys.lottery.*.dao.*"})
@ComponentScan(basePackages = {"com.yys.*"})
@SpringBootApplication
public class LotteryApiMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(LotteryApiMain.class);
        return super.configure(builder);
    }

    public static void main(String[] args){
        SpringApplication.run(LotteryApiMain.class,args);
    }
}
