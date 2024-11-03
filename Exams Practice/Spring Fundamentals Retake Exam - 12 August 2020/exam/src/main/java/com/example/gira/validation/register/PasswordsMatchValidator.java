package com.example.gira.validation.register;

import com.example.gira.model.dto.binding.UserRegisterBindingModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatchOnRegister, UserRegisterBindingModel> {

  @Override
  public boolean isValid(UserRegisterBindingModel model, ConstraintValidatorContext context) {
    String password = model.getPassword();
    String confirmPassword = model.getConfirmPassword();

    if (password == null || confirmPassword == null) {
      return true;
    }

    return password.equals(confirmPassword);
  }
}
