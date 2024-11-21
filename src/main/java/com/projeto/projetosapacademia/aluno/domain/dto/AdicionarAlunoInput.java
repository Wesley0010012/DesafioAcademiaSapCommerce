package com.projeto.projetosapacademia.aluno.domain.dto;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
@Data()
public final class AdicionarAlunoInput {

    private final String nome;
    private final String email;

    public Aluno toDomain() {
        return new Aluno(null, nome, email, null);
    }
}
