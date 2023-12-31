package com.assessment.rickandmortyapi.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig
{

    @Bean
    public GroupedOpenApi publicApi()
    {
        return GroupedOpenApi.builder().group( "v1" ).pathsToMatch( "/v1/**" ).build();
    }

    @Bean
    public OpenAPI openApiInfo()
    {
        return new OpenAPI()
                .info( new Info().title( "Ricky adn Morty Client" )
                        .description( "An example about retrieve and process data from a API" )
                        .version( "v0.0.1" )
                        .license( new License() ) );
    }
}
