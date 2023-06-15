package com.scotia.todo.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.scotia.todo.web.controller")).paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndoPointInfo());
    }

    private ApiInfo apiEndoPointInfo() {
        return new ApiInfoBuilder().title("API of TODOs").description("Todo service to create and manage pending task").license("Apache 2.0").version("1.0.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build();
    }
}

