package com.projeto.projetosapacademia.cursos.domain.dto;

import java.util.Date;

import com.projeto.projetosapacademia.shared.domain.entities.Curso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
@Data()
public final class CursoOutput {

    private final String nome;
    private final String descricao;
    private final Date dataCriacao;

    public static CursoOutput toDTO(Curso curso) {
        return new CursoOutput(curso.getNome(), curso.getDescricao(), curso.getDataCriacao());
    }
}
