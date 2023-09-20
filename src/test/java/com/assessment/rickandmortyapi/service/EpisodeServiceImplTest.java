package com.assessment.rickandmortyapi.service;

import com.assessment.rickandmortyapi.client.MonoApiClient;
import com.assessment.rickandmortyapi.dto.CharacterResponse;
import com.assessment.rickandmortyapi.dto.Episode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.assessment.rickandmortyapi.fixture.ApiResponseFixture.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class EpisodeServiceImplTest {

    @Autowired
    EpisodeServiceImpl episodeService;
    @MockBean
    private MonoApiClient apiClient;

    @Test
    void getFirstEpisode() {

        when(apiClient.getEpisode(anyString())).thenReturn(Episode.builder()
                .name("Pilot")
                .air_date("December 1 , 2013")
                .episode("https://rickandmortyapi.com/api/episode/1").build());

        CharacterResponse result = episodeService.getFirstEpisode(getEpisodeList(), "Rick Sanchez");

        assertEquals("December 1 , 2013",result.getFirst_appareance());
    }
}