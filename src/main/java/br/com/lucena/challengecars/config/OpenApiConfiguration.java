package br.com.lucena.challengecars.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(OpenApiConfiguration.class);

    @Bean
    public GroupedOpenApi publicApi() {
        logger.info("Configurando Springdoc OpenAPI...");
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("br.com.lucena.challengecars.controller") // Ajuste para o pacote correto onde seus controladores estão
                .build();
    }
}