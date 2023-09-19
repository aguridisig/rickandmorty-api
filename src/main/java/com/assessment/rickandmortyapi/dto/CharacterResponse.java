package com.assessment.rickandmortyapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CharacterResponse
{
    private String name;
    private List<String> episodes;
    private String first_appareance;
}
