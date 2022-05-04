package com.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

@Configuration
public class SwaggerConfig {
    private String version = "V1";
    private String title = "Chat API" + version;

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Chat")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chat.controller"))
                .paths(postPaths())
                .build();
    }
    private Predicate<String> postPaths() {
        return PathSelectors.any();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(title).description("Chat API Reference for Developers")
                .contact(new Contact("ssafy","https://edu.ssafy.com","ssafy@ssafy.com"))
                .license("Chat License")
                .licenseUrl("ssafy@ssafy.com").version(version).build();

    }
}