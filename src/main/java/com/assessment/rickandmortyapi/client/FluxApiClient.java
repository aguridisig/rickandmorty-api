package com.assessment.rickandmortyapi.client;

import com.assessment.rickandmortyapi.dto.Episode;
import com.assessment.rickandmortyapi.error.ApiException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
public class FluxApiClient {
    private final WebClient webClient;

    public FluxApiClient(final WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Episode> getEpisodes(final List<String> episodeList) {
        return webClient.get()
                .uri( "/api/episode/{episodes}", episodeList.toString() )
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                    throw new ApiException(500, "Server Error");
                })
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    throw new ApiException(404, "Not Found");
                })
                .bodyToFlux( Episode.class );
    }
}
