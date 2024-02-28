package com.encode.fresh.utils.HttpInterceptor;//package ke.co.waterquality.backend.utils.HttpInterceptor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.RequestParameterBuilder;
//import springfox.documentation.schema.ScalarType;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//public class SwaggerConfigNew {
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo("E&M WATER QUALITY MANAGEMENT SYSTEM",
//                "Comprehensive water mangement SOlution.",
//                "1.0",
//                "Terms of service",
//                new Contact("E&M", "www.emtechhouse.co.ke", "developer@emtechhouse.co.ke"),
//                "License of API",
//                "API license URL",
//                Collections.emptyList());
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey(AUTHORIZATION_HEADER, "Bearer", "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .build();
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference(AUTHORIZATION_HEADER, authorizationScopes));
//    }
//
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .apiInfo(apiInfo())
//                .globalRequestParameters(Arrays.asList(new RequestParameterBuilder().name("userName")
//                        .description("Remote User").in(ParameterType.HEADER).required(true)
//                        .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
//                                .allowEmptyValue(true).model(modelSpecificationBuilder -> modelSpecificationBuilder
//                                        .scalarModel(ScalarType.STRING)))
//                        .build())).globalRequestParameters(Arrays.asList(new RequestParameterBuilder().name("entityId")
//                        .description("Entity ID").in(ParameterType.HEADER).required(true)
//                        .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
//                                .allowEmptyValue(true).model(modelSpecificationBuilder -> modelSpecificationBuilder
//                                        .scalarModel(ScalarType.STRING)))
//                        .build()));
//    }
//}
