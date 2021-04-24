package com.technext.spring.resilience4j.registration.management.config;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SwaggerConfig {

    @Bean
    public Docket api() {
        log.info("Inside SwaggerConfig");
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                paths(PathSelectors.any()).
                apis(RequestHandlerSelectors.basePackage("com.technext.spring.resilience4j.registration.management.controller")).
                build().
                apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().
                title("Registration Service Rest API").
                description("Spring Boot Rest API").
                version("0.0.1").
                termsOfServiceUrl("Term of service").
                contact(new Contact("Spring Boot Support Team",
                        "http://localhost:8080/swagger-ui/index.html",
                        "SpringBootSupportTeam@test")).
                license("MIT Licence").
                licenseUrl("https://opensource.org/licenses/MIT").
                build();
    }
}
