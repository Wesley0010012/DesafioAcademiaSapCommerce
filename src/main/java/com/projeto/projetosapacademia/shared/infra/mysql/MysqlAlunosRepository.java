package com.projeto.projetosapacademia.shared.infra.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;
import com.projeto.projetosapacademia.shared.domain.gateways.EncontrarAlunoPorRegistroAcademico;
import com.projeto.projetosapacademia.shared.domain.gateways.RegistrarAluno;
import com.projeto.projetosapacademia.shared.domain.gateways.VerificarAlunoPorEmail;

@Repository()
public interface MysqlAlunosRepository extends JpaRepository<Aluno, Long>, RegistrarAluno, VerificarAlunoPorEmail, EncontrarAlunoPorRegistroAcademico {

}
