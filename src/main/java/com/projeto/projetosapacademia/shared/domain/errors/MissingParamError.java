package com.projeto.projetosapacademia.shared.domain.errors;

import org.springframework.http.HttpStatus;

public class MissingParamError extends CustomError {
    public MissingParamError(String param) {
        super("parâmetro faltante: " + param, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
