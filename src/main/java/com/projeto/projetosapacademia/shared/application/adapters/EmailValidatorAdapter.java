package com.projeto.projetosapacademia.shared.application.adapters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.projeto.projetosapacademia.shared.domain.gateways.EmailValidator;

@Component()
public class EmailValidatorAdapter implements EmailValidator {

    private final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    @Override()
    public Boolean validate(String email) {
        Pattern pattern = Pattern.compile(this.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
