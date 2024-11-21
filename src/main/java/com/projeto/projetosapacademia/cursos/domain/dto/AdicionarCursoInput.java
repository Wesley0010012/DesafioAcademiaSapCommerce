package com.projeto.projetosapacademia.cursos.domain.dto;

import com.projeto.projetosapacademia.shared.domain.entities.Curso;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
public class AdicionarCursoInput {

    private final String nome;
    private final String descricao;

    public Curso toDomain() {
        return new Curso(null, nome, descricao, null);
    }
}
