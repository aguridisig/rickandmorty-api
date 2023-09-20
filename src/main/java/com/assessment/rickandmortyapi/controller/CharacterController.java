package com.assessment.rickandmortyapi.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.assessment.rickandmortyapi.dto.CharacterResponse;
import com.assessment.rickandmortyapi.service.CharacterService;
import com.assessment.rickandmortyapi.service.EpisodeService;

@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class CharacterController
{
    private final CharacterService characterService;
    private final EpisodeService episodeService;
    public static final String PATH = "/search-character-appearance";

    @GetMapping(PATH)
    @ResponseStatus( HttpStatus.OK )
    @Operation( summary = "Return the first appearance of a given character and the name of the episode",
            description = "This API retrieve data from https://rickandmortyapi.com/ and find out the first appearance of a character" )
    CharacterResponse getCharacterFirstAppearance( @RequestParam final String name){

        final List<String> episodeList =  characterService.getCharacter( name );

       return episodeService.getFirstEpisode( episodeList, name );
    }
}
