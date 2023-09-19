package com.assessment.rickandmortyapi.client;

import com.assessment.rickandmortyapi.dto.ApiResponse;
import com.assessment.rickandmortyapi.error.ApiException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component
public class MonoApiClient {
    private final WebClient webClient;

    public MonoApiClient(final WebClient webClient) {
        this.webClient = webClient;
    }

    public ApiResponse getCharacter(final String name) {
        return webClient.get()
                .uri("/api/character/?name={name}", name)
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                    throw new ApiException(500, "Server Error");
                })
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    throw new ApiException(404, "Not Found");
                })
                .bodyToMono(ApiResponse.class)
                .block();
    }
}
