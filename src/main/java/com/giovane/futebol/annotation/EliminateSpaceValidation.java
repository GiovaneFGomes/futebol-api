package com.giovane.futebol.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;

public class EliminateSpaceValidation implements ConstraintValidator< EliminateSpace, String > {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.trim().equals("");
    }

}
