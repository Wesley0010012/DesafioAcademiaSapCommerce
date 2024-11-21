package com.projeto.projetosapacademia.shared.domain.gateways;

import com.projeto.projetosapacademia.shared.domain.entities.Curso;

public interface EncontrarCursoPorRegistro {

    public Curso findByRegistro(String registro);
}
