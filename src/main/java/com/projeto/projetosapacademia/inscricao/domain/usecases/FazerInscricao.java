package com.projeto.projetosapacademia.inscricao.domain.usecases;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.inscricao.domain.dto.FazerInscricaoInput;
import com.projeto.projetosapacademia.inscricao.domain.dto.InscricaoOutput;
import com.projeto.projetosapacademia.inscricao.domain.entities.Inscricao;
import com.projeto.projetosapacademia.inscricao.domain.errors.InscricaoJaExisteError;
import com.projeto.projetosapacademia.inscricao.domain.gateways.RegistrarInscricao;
import com.projeto.projetosapacademia.inscricao.domain.gateways.VerificarInscricaoPorAlunoECurso;
import com.projeto.projetosapacademia.shared.domain.entities.Aluno;
import com.projeto.projetosapacademia.shared.domain.entities.Curso;
import com.projeto.projetosapacademia.shared.domain.errors.AlunoNaoExisteError;
import com.projeto.projetosapacademia.shared.domain.errors.CursoNaoExisteError;
import com.projeto.projetosapacademia.shared.domain.gateways.EncontrarAlunoPorRegistroAcademico;
import com.projeto.projetosapacademia.shared.domain.gateways.EncontrarCursoPorRegistro;
import com.projeto.projetosapacademia.shared.domain.usecases.UseCase;

@Component()
public class FazerInscricao implements UseCase<FazerInscricaoInput, InscricaoOutput> {

    @Autowired()
    private EncontrarAlunoPorRegistroAcademico encontrarAlunoPorRegistroAcademico;

    @Autowired()
    private EncontrarCursoPorRegistro encontrarCursoPorRegistro;

    @Autowired()
    private VerificarInscricaoPorAlunoECurso verificarInscricaoPorAlunoECurso;

    @Autowired()
    private RegistrarInscricao registrarInscricao;

    @Override
    public InscricaoOutput execute(FazerInscricaoInput input) throws Exception {
        Aluno aluno = this.encontrarAlunoPorRegistroAcademico.findByRegistroAcademico(input.getRegistroAluno());

        if (Objects.isNull(aluno)) {
            throw new AlunoNaoExisteError(input.getRegistroAluno());
        }

        Curso curso = this.encontrarCursoPorRegistro.findByRegistro(input.getRegistroCurso());

        if (Objects.isNull(curso)) {
            throw new CursoNaoExisteError(input.getRegistroCurso());
        }

        if (this.verificarInscricaoPorAlunoECurso.existsByAlunoAndCurso(aluno, curso)) {
            throw new InscricaoJaExisteError(input.getRegistroCurso(), input.getRegistroAluno());
        }

        Inscricao inscricao = this.registrarInscricao.save(new Inscricao(null, aluno, curso, null));

        return InscricaoOutput.toDTO(inscricao);
    }

}
