package com.projeto.projetosapacademia.aluno.domain.dto;

import java.util.Date;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor()
@Getter()
@Data()
public final class AlunoOutput {

    private String nome;
    private String registroAcademico;
    private String email;
    private Date dataCadastro;

    public static AlunoOutput toDTO(Aluno aluno) {
        return new AlunoOutput(aluno.getNome(), aluno.getRegistroAcademico(), aluno.getEmail(), aluno.getDataCadastro());
    }
}
