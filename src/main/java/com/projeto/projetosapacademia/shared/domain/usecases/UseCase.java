package com.projeto.projetosapacademia.shared.domain.usecases;

public interface UseCase<Input, Output> {
    public Output execute(Input input) throws Exception;
}
