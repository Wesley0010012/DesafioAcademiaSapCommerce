package com.projeto.projetosapacademia.shared.domain.errors;

import org.springframework.http.HttpStatus;

public class InvalidParamError extends CustomError {

    public InvalidParamError(String param) {
        super("invalid param: " + param, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
