package com.yys.lottery.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问的地址:swagger-ui.html
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.yys.lottery.api"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建API文档的详细信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(" 彩票 Api")
                .contact(new Contact("tinTin","www.yys.com","fyx912@163.com"))
                .version("1.0.0")
                .description("Api 描述")
                .build();
    }
}
