package com.jorge.curso.springboot.app.springboot_crud.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IsExistsDbValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsExistsDb {

    String message() default "El elemento ya existe en la base de datos";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
