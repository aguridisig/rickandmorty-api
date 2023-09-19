package com.assessment.rickandmortyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Info
{
    private int count;
    private int pages;
    private String next;
    private String prev;
}
