package com.projeto.projetosapacademia.inscricao.infra.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetosapacademia.inscricao.domain.dto.FazerInscricaoInput;
import com.projeto.projetosapacademia.inscricao.domain.dto.InscricaoOutput;
import com.projeto.projetosapacademia.inscricao.domain.dto.ListarCursosPorAlunoOutput;
import com.projeto.projetosapacademia.inscricao.domain.dto.ListarInscricoesDeAlunosPorCursoOutput;
import com.projeto.projetosapacademia.inscricao.domain.dto.validators.FazerInscricaoInputValidator;
import com.projeto.projetosapacademia.inscricao.domain.usecases.FazerInscricao;
import com.projeto.projetosapacademia.inscricao.domain.usecases.ListarCursosPorAluno;
import com.projeto.projetosapacademia.inscricao.domain.usecases.ListarInscricoesDeAlunosPorCurso;

@RestController()
@RequestMapping("/inscricao")
public class InscricoesController {

    @Autowired()
    private FazerInscricaoInputValidator fazerInscricaoInputValidator;

    @Autowired()
    private FazerInscricao fazerInscricao;

    @Autowired()
    private ListarCursosPorAluno listarCursosPorAluno;

    @Autowired()
    private ListarInscricoesDeAlunosPorCurso listarInscricoesDeAlunosPorCurso;

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public InscricaoOutput create(@RequestBody(required = true) @Validated FazerInscricaoInput input) throws Exception {
        this.fazerInscricaoInputValidator.validate(input);

        return this.fazerInscricao.execute(input);
    }

    @GetMapping(path = "/aluno/{registro_aluno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarCursosPorAlunoOutput> buscarPorAluno(@PathVariable("registro_aluno") String input) throws Exception {

        return this.listarCursosPorAluno.execute(input);
    }

    @GetMapping(path = "/curso/{registro_curso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarInscricoesDeAlunosPorCursoOutput> buscarPorCurso(@PathVariable("registro_curso") String input) throws Exception {

        return this.listarInscricoesDeAlunosPorCurso.execute(input);
    }
}
