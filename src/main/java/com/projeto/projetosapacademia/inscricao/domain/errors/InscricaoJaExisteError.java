package com.projeto.projetosapacademia.inscricao.domain.errors;

import org.springframework.http.HttpStatus;

import com.projeto.projetosapacademia.shared.domain.errors.CustomError;

public class InscricaoJaExisteError extends CustomError {

    public InscricaoJaExisteError(String registroCurso, String registroAluno) {
        super("Curso " + registroCurso + " já foi efetivado para o aluno " + registroAluno, HttpStatus.CONFLICT);
    }
}
