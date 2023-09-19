package com.assessment.rickandmortyapi.service;

import java.util.List;
import com.assessment.rickandmortyapi.dto.CharacterResponse;

public interface EpisodeService
{
    public CharacterResponse getFirstEpisode( List<String> episodeList, String name);
}
