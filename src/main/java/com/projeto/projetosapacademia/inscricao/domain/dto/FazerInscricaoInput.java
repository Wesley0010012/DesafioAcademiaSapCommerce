package com.projeto.projetosapacademia.inscricao.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data()
@AllArgsConstructor()
@Getter()
public class FazerInscricaoInput {
    private final String registroAluno;
    private final String registroCurso;
}
