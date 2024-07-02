package br.com.lucena.challengecars.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(OpenApiConfiguration.class);

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("br.com.lucena.challengecars.controller")
                .build();
    }
}