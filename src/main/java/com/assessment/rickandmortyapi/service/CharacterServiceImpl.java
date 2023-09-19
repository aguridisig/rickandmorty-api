package com.assessment.rickandmortyapi.service;

import java.util.List;

import com.assessment.rickandmortyapi.client.MonoApiClient;
import org.springframework.stereotype.Service;

import com.assessment.rickandmortyapi.dto.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CharacterServiceImpl implements CharacterService {

    private final MonoApiClient monoApiClient;

    @Override
    public List<String> getCharacter(final String name) {
        final ApiResponse apiResponse = monoApiClient.getCharacter(name);

        return apiResponse.getResults().stream().findFirst().get().getEpisode().stream()
                .map(e -> e.substring(e.lastIndexOf("/") + 1)).toList();

    }

}
