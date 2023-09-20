package com.assessment.rickandmortyapi.service;

import java.util.List;
import java.util.stream.Stream;

import com.assessment.rickandmortyapi.client.MonoApiClient;
import org.springframework.stereotype.Service;
import com.assessment.rickandmortyapi.dto.CharacterResponse;
import com.assessment.rickandmortyapi.dto.Episode;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.util.Collections.min;

@Service
@Slf4j
@AllArgsConstructor
public class EpisodeServiceImpl implements EpisodeService
{
    private final MonoApiClient apiClient;

    @Override
    public CharacterResponse getFirstEpisode(final List<String> episodeList, final String name )
    {

        final Episode episodeResponse = apiClient.getEpisode( min(episodeList));

        return CharacterResponse.builder()
                .name( name )
                .episodes( Stream.of(episodeResponse.getName()).toList() )
                .first_appareance( episodeResponse.getAir_date() )
                .build();
    }
}