package com.projeto.projetosapacademia.shared.infra.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projetosapacademia.shared.domain.entities.Curso;
import com.projeto.projetosapacademia.shared.domain.gateways.RegistrarCurso;
import com.projeto.projetosapacademia.shared.domain.gateways.VerificarCursoPorNome;

@Repository()
public interface MysqlCursosRepository extends JpaRepository<Curso, Long>,
        VerificarCursoPorNome, RegistrarCurso {

}
