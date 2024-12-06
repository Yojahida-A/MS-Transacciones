package com.banco.transactionsMS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI TransactionOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Transactions")
                        .version("1.0")
                        .description("Documentación de la API de Transactions")
                );
    }


}
