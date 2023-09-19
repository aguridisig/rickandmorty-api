package com.assessment.rickandmortyapi.service;


import com.assessment.rickandmortyapi.client.MonoApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.assessment.rickandmortyapi.fixture.ApiResponseFixture.getApiResponseFixture;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterServiceImplTest {

    @InjectMocks
    CharacterServiceImpl characterServiceMock;
    @Mock
    private MonoApiClient monoApiClient;


    @Test
    void getCharacter() {

        when(monoApiClient.getCharacter(anyString())).thenReturn(getApiResponseFixture());

        final List<String> result =characterServiceMock.getCharacter("Rick Sanchez");
        assertEquals("15",result.get(0));
    }
}