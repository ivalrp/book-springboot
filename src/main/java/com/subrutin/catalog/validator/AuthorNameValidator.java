package com.subrutin.catalog.validator;

import com.subrutin.catalog.validator.annotation.ValidAuthorName;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AuthorNameValidator implements ConstraintValidator<ValidAuthorName, String> {

    @Override
    public boolean isValid(String authorName, ConstraintValidatorContext context) {
        return !authorName.equalsIgnoreCase("Tedy");
    }
}
