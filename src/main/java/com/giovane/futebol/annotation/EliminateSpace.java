package com.giovane.futebol.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EliminateSpaceValidation.class)
public @interface EliminateSpace {
    String message() default "fields cannot be whitespace at both ends";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
