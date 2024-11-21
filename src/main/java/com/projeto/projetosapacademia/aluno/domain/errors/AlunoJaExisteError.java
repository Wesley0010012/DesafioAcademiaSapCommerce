package com.projeto.projetosapacademia.aluno.domain.errors;

import org.springframework.http.HttpStatus;

import com.projeto.projetosapacademia.shared.domain.errors.CustomError;

public class AlunoJaExisteError extends CustomError {

    public AlunoJaExisteError() {
        super("Aluno já registrado anteriormente", HttpStatus.CONFLICT);
    }
}
