package com.projeto.projetosapacademia.shared.domain.errors;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter()
public class CustomError extends RuntimeException {
    private final HttpStatus statusCode;

    public CustomError(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
