package com.projeto.projetosapacademia.inscricao.domain.dto;

import java.util.Date;

import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
public class InscricaoOutput {

    private final String registroAluno;
    private final String registroCurso;
    private final Date dataInscricao;

    public static InscricaoOutput toDTO(Inscricao inscricao) {
        return new InscricaoOutput(inscricao.getAluno().getRegistroAcademico(), inscricao.getCurso().getRegistro(), inscricao.getDataInscricao());
    }
}
