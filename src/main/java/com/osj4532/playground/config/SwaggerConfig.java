package com.osj4532.playground.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 210501 | osj4532 | created
 */

@Configuration
public class SwaggerConfig {
    private Info getInfo() {
        return new Info()
                .title("Playground API")
                .description("Osj`s Playground Spring Rest Documentation")
                .version("v0.0.1")
                .license(
                        new License().name("Apache 2.0")
                                .url("https://springdoc.org")
                );
    }

    private ExternalDocumentation getExtraDocs() {
        return new ExternalDocumentation()
                .description("Playground Github Documentation")
                .url("https://github.com/Ohsj/playground/tree/main/docs");
    }

    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI()
                .info(getInfo())
                .externalDocs(getExtraDocs());
    }
}
