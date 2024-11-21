package com.projeto.projetosapacademia.shared.domain.gateways;

public interface VerificarAlunoPorEmail {

    public Boolean existsByEmail(String email);
}
