package com.projeto.projetosapacademia.shared.domain.dto.validators;

public interface Validator<T> {

    public void validate(T input) throws Exception;
}
