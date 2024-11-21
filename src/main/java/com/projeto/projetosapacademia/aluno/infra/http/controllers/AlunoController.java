package com.projeto.projetosapacademia.aluno.infra.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetosapacademia.aluno.domain.dto.AdicionarAlunoInput;
import com.projeto.projetosapacademia.aluno.domain.dto.AlunoOutput;
import com.projeto.projetosapacademia.aluno.domain.dto.validators.AdicionarAlunoInputValidator;
import com.projeto.projetosapacademia.aluno.domain.usecases.AdicionarAluno;

@RestController()
public class AlunoController {

    @Autowired()
    private AdicionarAluno adicionarAluno;

    @Autowired()
    private AdicionarAlunoInputValidator adicionarAlunoInputValidator;

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public AlunoOutput create(@RequestBody(required = true) @Validated AdicionarAlunoInput input) throws Exception {
        this.adicionarAlunoInputValidator.validate(input);

        return this.adicionarAluno.execute(input);
    }
}
