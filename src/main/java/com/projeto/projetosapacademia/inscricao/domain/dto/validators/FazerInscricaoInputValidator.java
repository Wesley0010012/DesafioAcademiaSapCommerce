package com.projeto.projetosapacademia.inscricao.domain.dto.validators;

import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.inscricao.domain.dto.FazerInscricaoInput;
import com.projeto.projetosapacademia.shared.domain.dto.validators.Validator;
import com.projeto.projetosapacademia.shared.domain.errors.MissingParamError;

@Component()
public class FazerInscricaoInputValidator implements Validator<FazerInscricaoInput> {

    @Override
    public void validate(FazerInscricaoInput input) throws Exception {
        if (input.getRegistroAluno() == null || input.getRegistroAluno().isEmpty()) {
            throw new MissingParamError("registroAluno");
        }

        if (input.getRegistroCurso() == null || input.getRegistroCurso().isEmpty()) {
            throw new MissingParamError("registroCurso");
        }
    }

}
