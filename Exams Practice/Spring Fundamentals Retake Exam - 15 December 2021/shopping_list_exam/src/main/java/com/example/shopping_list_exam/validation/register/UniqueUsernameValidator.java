package com.example.shopping_list_exam.validation.register;

import com.example.shopping_list_exam.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  private final UserService userService;

  public UniqueUsernameValidator(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (username == null) {
      return true;
    }
    return userService.isUserNameAvailable(username);
  }
}
