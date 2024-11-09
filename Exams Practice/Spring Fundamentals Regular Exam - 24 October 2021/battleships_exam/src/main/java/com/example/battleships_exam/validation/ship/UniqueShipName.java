package com.example.battleships_exam.validation.ship;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueShipNameValidator.class)
public @interface UniqueShipName {

  String message() default "Ship's name already exists";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
