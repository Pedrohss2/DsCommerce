package com.ph.dscommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI getOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Dscommerce to buy")
                        .description("Sales ecommerce")
                        .version("1.0.0").license(new License().name("Licensa do sistema").url("urlaleatoria.com")));
    }



}
