package com.assessment.rickandmortyapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {
    @Value("${baseurl}")
    private String baseUrl;
    @Bean
    public WebClient webClient() {

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
