package com.example.gira.service;

import com.example.gira.model.dto.service.UserRegisterServiceModel;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerUser(UserRegisterServiceModel serviceModel);
}
