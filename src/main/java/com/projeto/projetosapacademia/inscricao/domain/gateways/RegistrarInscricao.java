package com.projeto.projetosapacademia.inscricao.domain.gateways;

import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;

public interface RegistrarInscricao {

    public Inscricao save(Inscricao inscricao);
}
