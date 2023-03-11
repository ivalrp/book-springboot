package com.subrutin.catalog.validator.annotation;

import com.subrutin.catalog.validator.AuthorNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AuthorNameValidator.class)
public @interface ValidAuthorName {

    String message() default "author name invalid";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}
