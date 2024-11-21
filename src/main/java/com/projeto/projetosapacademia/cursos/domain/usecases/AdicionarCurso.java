package com.projeto.projetosapacademia.cursos.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.cursos.domain.dto.AdicionarCursoInput;
import com.projeto.projetosapacademia.cursos.domain.dto.CursoOutput;
import com.projeto.projetosapacademia.cursos.domain.errors.CursoJaExisteError;
import com.projeto.projetosapacademia.shared.domain.entities.Curso;
import com.projeto.projetosapacademia.shared.domain.gateways.RegistrarCurso;
import com.projeto.projetosapacademia.shared.domain.gateways.VerificarCursoPorNome;
import com.projeto.projetosapacademia.shared.domain.usecases.UseCase;

@Component()
public class AdicionarCurso implements UseCase<AdicionarCursoInput, CursoOutput> {

    @Autowired()
    private VerificarCursoPorNome verificarCursoPorNome;

    @Autowired()
    private RegistrarCurso registrarCurso;

    @Override()
    public CursoOutput execute(AdicionarCursoInput input) throws Exception {
        if (this.verificarCursoPorNome.existsByNome(input.getNome())) {
            throw new CursoJaExisteError();
        }

        Curso curso = this.registrarCurso.save(input.toDomain());

        return CursoOutput.toDTO(curso);
    }

}
