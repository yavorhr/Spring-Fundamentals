package com.example.shopping_list_exam.validation.register;

import com.example.shopping_list_exam.model.binding.UserRegisterBindingModel;
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
