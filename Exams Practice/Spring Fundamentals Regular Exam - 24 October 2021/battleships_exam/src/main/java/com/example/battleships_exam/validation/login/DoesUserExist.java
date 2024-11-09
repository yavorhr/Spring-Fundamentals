package com.example.battleships_exam.validation.login;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailAndPasswordValidator.class)
public @interface DoesUserExist {
  String message() default "Incorrect email or password!";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
