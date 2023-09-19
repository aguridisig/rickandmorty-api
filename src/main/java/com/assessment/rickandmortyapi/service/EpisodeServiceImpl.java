package com.assessment.rickandmortyapi.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.assessment.rickandmortyapi.client.FluxApiClient;
import org.springframework.stereotype.Service;
import com.assessment.rickandmortyapi.dto.CharacterResponse;
import com.assessment.rickandmortyapi.dto.Episode;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@AllArgsConstructor
public class EpisodeServiceImpl implements EpisodeService
{
    private final FluxApiClient apiClient;

    @Override
    public CharacterResponse getFirstEpisode(final List<String> episodeList, final String name )
    {
        final Flux<Episode> episodesResponse = apiClient.getEpisodes( episodeList);

        final Optional<Episode> firstEpisode =
                episodesResponse.toStream().min( Comparator.comparing( Episode::getAir_date ) );

        log.info( firstEpisode.toString() );

        return CharacterResponse.builder()
                .name( name )
                .episodes( episodesResponse.toStream().map( Episode::getName ).toList() )
                .first_appareance( firstEpisode.get().getAir_date() )
                .build();
    }
}
