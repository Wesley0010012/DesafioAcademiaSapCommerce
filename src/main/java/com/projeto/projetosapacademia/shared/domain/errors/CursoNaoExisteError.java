package com.projeto.projetosapacademia.shared.domain.errors;

import org.springframework.http.HttpStatus;

public class CursoNaoExisteError extends CustomError {

    public CursoNaoExisteError(String registro) {
        super("Curso não encontrado com o registro: " + registro, HttpStatus.NOT_FOUND);
    }
}
