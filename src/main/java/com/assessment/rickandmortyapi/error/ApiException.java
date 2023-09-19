package com.assessment.rickandmortyapi.error;

import lombok.Builder;
import lombok.Getter;


@Getter
public class ApiException extends RuntimeException
{
    private final int statusCode;

    @Builder
    public ApiException(final int statusCode, final String message ){
        super(message);
        this.statusCode = statusCode;
    }
}
