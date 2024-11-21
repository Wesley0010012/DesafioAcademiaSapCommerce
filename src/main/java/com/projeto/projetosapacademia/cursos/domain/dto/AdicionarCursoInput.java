package com.projeto.projetosapacademia.cursos.domain.dto;

import com.projeto.projetosapacademia.shared.domain.entities.Curso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor()
@Getter()
@Setter()
public class AdicionarCursoInput {

    private final String nome;
    private final String descricao;
    private String registro;

    public Curso toDomain() {
        return new Curso(null, nome, registro, descricao, null);
    }
}
