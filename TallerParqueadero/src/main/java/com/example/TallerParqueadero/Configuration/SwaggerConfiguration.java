package com.example.TallerParqueadero.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customopenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("API de Parqueadero")
                        .version("1.0")
                        .description("Documentación de la APi para gestionar Parqueadero")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("juannromero@ucundinamarca.edu.co")));
    }
}
