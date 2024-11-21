package com.projeto.projetosapacademia.aluno.domain.dto;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor()
@Getter()
@Setter()
@Data()
public final class AdicionarAlunoInput {

    private final String nome;
    private final String email;
    private String registroAcademico;

    public Aluno toDomain() {
        return new Aluno(null, nome, registroAcademico, email, null);
    }
}
