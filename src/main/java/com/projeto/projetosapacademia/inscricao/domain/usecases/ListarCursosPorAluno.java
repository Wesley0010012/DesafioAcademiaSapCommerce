package com.projeto.projetosapacademia.inscricao.domain.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.inscricao.domain.dto.ListarCursosPorAlunoOutput;
import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;
import com.projeto.projetosapacademia.inscricao.domain.gateways.BuscarInscricoesPorAluno;
import com.projeto.projetosapacademia.shared.domain.entities.Aluno;
import com.projeto.projetosapacademia.shared.domain.errors.AlunoNaoExisteError;
import com.projeto.projetosapacademia.shared.domain.gateways.EncontrarAlunoPorRegistroAcademico;
import com.projeto.projetosapacademia.shared.domain.usecases.UseCase;

@Component()
public class ListarCursosPorAluno implements UseCase<String, List<ListarCursosPorAlunoOutput>> {

    @Autowired()
    private EncontrarAlunoPorRegistroAcademico encontrarAlunoPorRegistroAcademico;

    @Autowired()
    private BuscarInscricoesPorAluno buscarInscricoesPorAluno;

    @Override
    public List<ListarCursosPorAlunoOutput> execute(String input) throws Exception {
        Aluno aluno = this.encontrarAlunoPorRegistroAcademico.findByRegistroAcademico(input);

        if (Objects.isNull(aluno)) {
            throw new AlunoNaoExisteError(input);
        }

        List<Inscricao> inscricoes = this.buscarInscricoesPorAluno.findAllByAluno(aluno);

        List<ListarCursosPorAlunoOutput> cursos = new ArrayList<>();

        for (Inscricao inscricao : inscricoes) {
            cursos.add(ListarCursosPorAlunoOutput.toDTO(inscricao));
        }

        return cursos;
    }

}
