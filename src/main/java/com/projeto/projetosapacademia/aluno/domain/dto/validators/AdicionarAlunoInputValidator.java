package com.projeto.projetosapacademia.aluno.domain.dto.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.aluno.domain.dto.AdicionarAlunoInput;
import com.projeto.projetosapacademia.shared.domain.dto.validators.Validator;
import com.projeto.projetosapacademia.shared.domain.errors.InvalidParamError;
import com.projeto.projetosapacademia.shared.domain.errors.MissingParamError;
import com.projeto.projetosapacademia.shared.domain.gateways.EmailValidator;

@Component()
public class AdicionarAlunoInputValidator implements Validator<AdicionarAlunoInput> {

    @Autowired()
    private EmailValidator emailValidator;

    @Override
    public void validate(AdicionarAlunoInput input) throws Exception {
        if (input.getNome() == null || input.getNome().isEmpty()) {
            throw new MissingParamError("nome");
        }

        if (input.getEmail() == null || input.getEmail().isEmpty()) {
            throw new MissingParamError("email");
        }

        if (!this.emailValidator.validate(input.getEmail())) {
            throw new InvalidParamError("email");
        }
    }
}
