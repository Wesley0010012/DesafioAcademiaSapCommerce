package com.projeto.projetosapacademia.inscricao.domain.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.inscricao.domain.dto.ListarInscricoesDeAlunosPorCursoOutput;
import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;
import com.projeto.projetosapacademia.inscricao.domain.gateways.BuscarInscricoesPorCurso;
import com.projeto.projetosapacademia.shared.domain.entities.Curso;
import com.projeto.projetosapacademia.shared.domain.errors.CursoNaoExisteError;
import com.projeto.projetosapacademia.shared.domain.gateways.EncontrarCursoPorRegistro;
import com.projeto.projetosapacademia.shared.domain.usecases.UseCase;

@Component()
public class ListarInscricoesDeAlunosPorCurso implements UseCase<String, List<ListarInscricoesDeAlunosPorCursoOutput>> {

    @Autowired()
    private EncontrarCursoPorRegistro encontrarCursoPorRegistro;

    @Autowired()
    private BuscarInscricoesPorCurso buscarInscricoesPorCurso;

    @Override
    public List<ListarInscricoesDeAlunosPorCursoOutput> execute(String input) throws Exception {
        Curso curso = this.encontrarCursoPorRegistro.findByRegistro(input);

        if (Objects.isNull(curso)) {
            throw new CursoNaoExisteError(input);
        }

        List<Inscricao> inscricoes = this.buscarInscricoesPorCurso.findAllByCurso(curso);

        List<ListarInscricoesDeAlunosPorCursoOutput> inscricoesAlunos = new ArrayList<>();

        for (Inscricao inscricao : inscricoes) {
            inscricoesAlunos.add(ListarInscricoesDeAlunosPorCursoOutput.toDTO(inscricao));
        }

        return inscricoesAlunos;
    }

}
