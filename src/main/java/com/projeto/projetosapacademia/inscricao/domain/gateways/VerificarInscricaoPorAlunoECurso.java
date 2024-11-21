package com.projeto.projetosapacademia.inscricao.domain.gateways;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;
import com.projeto.projetosapacademia.shared.domain.entities.Curso;

public interface VerificarInscricaoPorAlunoECurso {

    public Boolean existsByAlunoAndCurso(Aluno aluno, Curso curso);
}
