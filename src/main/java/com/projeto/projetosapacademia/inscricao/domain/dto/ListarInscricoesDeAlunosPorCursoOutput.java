package com.projeto.projetosapacademia.inscricao.domain.dto;

import java.util.Date;

import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
public class ListarInscricoesDeAlunosPorCursoOutput {

    private final String nomeAluno;
    private final String registroAcademico;
    private final Date dataInscricao;

    public static ListarInscricoesDeAlunosPorCursoOutput toDTO(Inscricao inscricao) {
        return new ListarInscricoesDeAlunosPorCursoOutput(inscricao.getAluno().getNome(), inscricao.getAluno().getRegistroAcademico(), inscricao.getDataInscricao());
    }
}
