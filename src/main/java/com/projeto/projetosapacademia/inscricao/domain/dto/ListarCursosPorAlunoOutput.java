package com.projeto.projetosapacademia.inscricao.domain.dto;

import java.util.Date;

import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
public class ListarCursosPorAlunoOutput {

    private final String curso;
    private final Date dataInscricao;

    public static ListarCursosPorAlunoOutput toDTO(Inscricao inscricao) {
        return new ListarCursosPorAlunoOutput(inscricao.getCurso().getNome(), inscricao.getDataInscricao());
    }
}
