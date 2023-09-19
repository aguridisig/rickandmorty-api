package com.assessment.rickandmortyapi.service;

import com.assessment.rickandmortyapi.client.FluxApiClient;
import com.assessment.rickandmortyapi.dto.CharacterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.assessment.rickandmortyapi.fixture.ApiResponseFixture.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EpisodeServiceImplTest {

    @Autowired
    EpisodeServiceImpl episodeService;
    @MockBean
    private FluxApiClient apiClient;

    @Test
    void getFirstEpisode() {

        when(apiClient.getEpisodes(getEpisodeList())).thenReturn(getFluxEpisodes());

        CharacterResponse result = episodeService.getFirstEpisode(getEpisodeList(), "Rick Sanchez");

        assertEquals("December 1 , 2013",result.getFirst_appareance());
    }
}