package com.projeto.projetosapacademia.inscricao.domain.gateways;

import java.util.List;

import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;
import com.projeto.projetosapacademia.shared.domain.entities.Aluno;

public interface BuscarInscricoesPorAluno {
    public List<Inscricao> findAllByAluno(Aluno aluno);
}
