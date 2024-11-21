package com.projeto.projetosapacademia.aluno.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.aluno.domain.dto.AdicionarAlunoInput;
import com.projeto.projetosapacademia.aluno.domain.dto.AlunoOutput;
import com.projeto.projetosapacademia.aluno.domain.errors.AlunoJaExisteError;
import com.projeto.projetosapacademia.shared.domain.entities.Aluno;
import com.projeto.projetosapacademia.shared.domain.gateways.RegistrarAluno;
import com.projeto.projetosapacademia.shared.domain.gateways.VerificarAlunoPorEmail;
import com.projeto.projetosapacademia.shared.domain.usecases.UseCase;

@Component()
public class AdicionarAluno implements UseCase<AdicionarAlunoInput, AlunoOutput> {

    @Autowired()
    private VerificarAlunoPorEmail verificarAlunoPorEmail;

    @Autowired()
    private RegistrarAluno registrarAluno;

    @Override()
    public AlunoOutput execute(AdicionarAlunoInput input) throws Exception {
        if (this.verificarAlunoPorEmail.existsByEmail(input.getEmail())) {
            throw new AlunoJaExisteError();
        }

        Aluno aluno = this.registrarAluno.save(input.toDomain());

        return AlunoOutput.toDTO(aluno);
    }
}
