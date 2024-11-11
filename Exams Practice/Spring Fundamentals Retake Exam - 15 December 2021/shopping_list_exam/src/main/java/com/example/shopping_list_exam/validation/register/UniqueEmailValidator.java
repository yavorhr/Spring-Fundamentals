package com.example.shopping_list_exam.validation.register;

import com.example.shopping_list_exam.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
  private final UserService userService;

  public UniqueEmailValidator(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    if (email == null || email.isBlank()) {
      return true;
    }

    return userService.isEmailAvailable(email);
  }
}
