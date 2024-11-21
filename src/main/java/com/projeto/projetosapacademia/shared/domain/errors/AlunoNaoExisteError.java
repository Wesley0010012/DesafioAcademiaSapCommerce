package com.projeto.projetosapacademia.shared.domain.errors;

import org.springframework.http.HttpStatus;

public class AlunoNaoExisteError extends CustomError {

    public AlunoNaoExisteError(String registroAluno) {
        super("Aluno não encontrado com o registro: " + registroAluno, HttpStatus.NOT_FOUND);
    }
}
