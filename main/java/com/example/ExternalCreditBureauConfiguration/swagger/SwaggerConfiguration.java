package com.example.ExternalCreditBureauConfiguration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.Data;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("swagger")
@OpenAPIDefinition
@EnableAutoConfiguration
@Data
public class SwaggerConfiguration {
    Map<String, String> properties = new HashMap<>();


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .packagesToScan("com.example")
                .build();
    }
}
