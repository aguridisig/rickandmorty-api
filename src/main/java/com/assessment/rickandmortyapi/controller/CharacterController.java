package com.assessment.rickandmortyapi.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.rickandmortyapi.dto.CharacterResponse;
import com.assessment.rickandmortyapi.service.CharacterService;
import com.assessment.rickandmortyapi.service.EpisodeService;

@RestController
@AllArgsConstructor
public class CharacterController
{
    private final CharacterService characterService;
    private final EpisodeService episodeService;
    public static final String PATH = "/search-character-appearance";

    @GetMapping(PATH)
    CharacterResponse getCharacterFirstAppearance( @RequestParam final String name){

        final List<String> episodeList =  characterService.getCharacter( name );

       return episodeService.getFirstEpisode( episodeList, name );
    }
}
