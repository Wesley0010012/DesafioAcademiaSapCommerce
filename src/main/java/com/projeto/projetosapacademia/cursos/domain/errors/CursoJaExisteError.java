package com.projeto.projetosapacademia.cursos.domain.errors;

import org.springframework.http.HttpStatus;

import com.projeto.projetosapacademia.shared.domain.errors.CustomError;

public class CursoJaExisteError extends CustomError {

    public CursoJaExisteError() {
        super("Curso já registrado anteriormente", HttpStatus.CONFLICT);
    }
}
