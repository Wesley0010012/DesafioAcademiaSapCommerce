package com.projeto.projetosapacademia.cursos.domain.dto.validators;

import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.cursos.domain.dto.AdicionarCursoInput;
import com.projeto.projetosapacademia.shared.domain.dto.validators.Validator;
import com.projeto.projetosapacademia.shared.domain.errors.MissingParamError;

@Component()
public class AdicionarCursoInputValidator implements Validator<AdicionarCursoInput> {

    @Override()
    public void validate(AdicionarCursoInput input) throws Exception {
        if (input.getNome() == null || input.getNome().isEmpty()) {
            throw new MissingParamError("nome");
        }

        if (input.getDescricao() == null || input.getDescricao().isEmpty()) {
            throw new MissingParamError("descricao");
        }
    }
}
