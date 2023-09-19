package com.assessment.rickandmortyapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character
{
    int id;
    String name;
    String status;
    String species;
    String type;
    String gender;
    Location location;
    String image;
    List<String> episode;
    String url;
    String created;
}
