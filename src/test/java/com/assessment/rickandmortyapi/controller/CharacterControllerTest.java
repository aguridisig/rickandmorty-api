package com.assessment.rickandmortyapi.controller;

import com.assessment.rickandmortyapi.dto.CharacterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.stream.Stream;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CharacterControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void getCharacterFirstAppearance() {
         webTestClient.get().uri(CharacterController.PATH+"?name=Amish Cyborg")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody(CharacterResponse.class)
                 .isEqualTo(CharacterResponse.builder()
                         .name("Amish Cyborg")
                         .episodes(Stream.of("Total Rickall").toList())
                         .first_appareance("August 16, 2015")
                         .build());

    }
}