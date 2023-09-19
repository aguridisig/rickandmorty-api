package com.assessment.rickandmortyapi.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMapper {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<MyErrorResponse> handleExceptionNotAuthorizedException(final ApiException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body(new MyErrorResponse(exception.getStatusCode(), exception.getMessage()));
    }
}
