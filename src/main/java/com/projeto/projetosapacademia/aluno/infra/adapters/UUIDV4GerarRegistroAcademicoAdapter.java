package com.projeto.projetosapacademia.aluno.infra.adapters;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.aluno.domain.gateways.GerarRegistroAcademico;

@Component()
public class UUIDV4GerarRegistroAcademicoAdapter implements GerarRegistroAcademico {

    @Override()
    public String gerar() {
        return UUID.randomUUID().toString();
    }

}
