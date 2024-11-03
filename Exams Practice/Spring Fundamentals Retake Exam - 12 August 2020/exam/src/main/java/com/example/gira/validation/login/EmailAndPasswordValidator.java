package com.example.gira.validation.login;

import com.example.gira.model.dto.binding.UserLoginBindingModel;
import com.example.gira.model.dto.service.UserLoginServiceModel;
import com.example.gira.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.modelmapper.ModelMapper;

public class EmailAndPasswordValidator implements ConstraintValidator<DoesUserExist, UserLoginBindingModel> {
  private final UserService userService;
  private final ModelMapper modelMapper;

  public EmailAndPasswordValidator(UserService userService, ModelMapper modelMapper) {
    this.userService = userService;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean isValid(UserLoginBindingModel userLoginBindingModel, ConstraintValidatorContext context) {
    String email = userLoginBindingModel.getPassword();
    String password = userLoginBindingModel.getPassword();

    if (email == null || password == null) {
      return true;
    }

    return this.userService.doesUserExist(this.modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));
  }
}
