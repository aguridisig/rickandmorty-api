package com.assessment.rickandmortyapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Episode
{
    int id;
    String name;
    String air_date;
    String episode;
    List<String> characters;
    String url;
    String created;
}