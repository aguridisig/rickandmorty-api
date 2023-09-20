package com.assessment.rickandmortyapi.fixture;

import com.assessment.rickandmortyapi.dto.*;
import com.assessment.rickandmortyapi.dto.Character;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApiResponseFixture {

    public static ApiResponse getApiResponseFixture() {
        final Info infoFixture = Info.builder().build();

        final List<String> episodes = new ArrayList<>();
        episodes.add("https://rickandmortyapi.com/api/episode/15");

        final List<Character> characterList = new ArrayList<>();
        characterList.add(Character.builder()
                .episode(episodes)
                .build());

        return ApiResponse.builder()
                .info(infoFixture)
                .results(characterList)
                .build();
    }

    public static List<String> getEpisodeList(){

        return Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList());

    }
}
