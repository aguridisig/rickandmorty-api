package com.assessment.rickandmortyapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    String url;
    String created;
}