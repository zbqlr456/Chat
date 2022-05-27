package com.ssafy.backend_chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    private String version = "V1";
    private String title = "Chatting API " + version;

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("Chatting")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ssafy.backend_chat.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(title).description("Chatting API Reference for Developers")
                .contact(new Contact("ssafy","https://edu.ssafy.com","ssafy@ssafy.com"))
                .license("Chatting License")
                .licenseUrl("ssafy@ssafy.com").version(version).build();

    }
}