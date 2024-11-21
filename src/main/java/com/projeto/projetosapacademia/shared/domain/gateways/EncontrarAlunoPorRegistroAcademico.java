package com.projeto.projetosapacademia.shared.domain.gateways;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;

public interface EncontrarAlunoPorRegistroAcademico {

    public Aluno findByRegistroAcademico(String registroAcademico);
}
