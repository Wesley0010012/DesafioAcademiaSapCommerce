package com.projeto.projetosapacademia.cursos.infra.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projetosapacademia.cursos.domain.dto.AdicionarCursoInput;
import com.projeto.projetosapacademia.cursos.domain.dto.CursoOutput;
import com.projeto.projetosapacademia.cursos.domain.dto.validators.AdicionarCursoInputValidator;
import com.projeto.projetosapacademia.cursos.domain.usecases.AdicionarCurso;

@RestController()
@RequestMapping("/curso")
public class CursoController {

    @Autowired()
    private AdicionarCurso adicionarCurso;

    @Autowired()
    private AdicionarCursoInputValidator adicionarCursoInputValidator;

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoOutput create(@RequestBody(required = true) @Validated AdicionarCursoInput input) throws Exception {
        this.adicionarCursoInputValidator.validate(input);

        return this.adicionarCurso.execute(input);
    }
}
