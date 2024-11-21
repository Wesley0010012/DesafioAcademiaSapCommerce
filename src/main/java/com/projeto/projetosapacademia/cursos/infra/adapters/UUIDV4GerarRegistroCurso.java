package com.projeto.projetosapacademia.cursos.infra.adapters;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.cursos.domain.gateways.GerarRegistroCurso;

@Component()
public class UUIDV4GerarRegistroCurso implements GerarRegistroCurso {

    @Override
    public String gerar() {
        return UUID.randomUUID().toString();
    }

}
