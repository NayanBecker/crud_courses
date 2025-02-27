package com.courses.api.crud_courses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                    .info(new Info().title("Crud de Cursos").description("API responsável pela gestão de cursos").version("1"));
                    }
}
