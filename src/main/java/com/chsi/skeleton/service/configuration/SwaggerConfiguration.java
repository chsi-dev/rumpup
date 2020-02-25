package com.chsi.skeleton.service.configuration;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
