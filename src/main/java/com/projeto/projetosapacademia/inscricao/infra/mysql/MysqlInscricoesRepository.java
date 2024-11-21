package com.projeto.projetosapacademia.inscricao.infra.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;
import com.projeto.projetosapacademia.inscricao.domain.gateways.BuscarInscricoesPorAluno;
import com.projeto.projetosapacademia.inscricao.domain.gateways.RegistrarInscricao;
import com.projeto.projetosapacademia.inscricao.domain.gateways.VerificarInscricaoPorAlunoECurso;

@Repository()
public interface MysqlInscricoesRepository extends JpaRepository<Inscricao, Long>, RegistrarInscricao, VerificarInscricaoPorAlunoECurso, BuscarInscricoesPorAluno {

}
