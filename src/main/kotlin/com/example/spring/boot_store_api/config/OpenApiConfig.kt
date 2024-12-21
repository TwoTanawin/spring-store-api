package com.example.spring.boot_store_api.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme

import io.swagger.v3.oas.models.tags.Tag

@Configuration
class OpenApiConfig {

    val securitySchemeName = "bearerAuth"

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Store API with Spring Boot and PostgreSQL")
                    .version("1.0")
                    .description("This is Store API using Spring Boot and PostgreSQL")
            )
            // Add Security JWT
            .addSecurityItem(SecurityRequirement().addList(securitySchemeName))
            .components(
                Components()
                    .addSecuritySchemes(
                        securitySchemeName,
                        SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            )
            .tags(
                listOf(
                    Tag().name("Authenticate").description("Authenticate APIs"),
                    Tag().name("Categories").description("Category management APIs"),
                    Tag().name("Products").description("Product management APIs")
                )
            )
    }
}