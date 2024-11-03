package com.example.gira.validation.addTask;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueTaskNameValidator.class)
public @interface UniqueTaskName {

  String message() default "Task name already exists";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
