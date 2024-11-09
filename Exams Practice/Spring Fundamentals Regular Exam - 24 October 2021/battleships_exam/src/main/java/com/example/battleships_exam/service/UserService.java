package com.example.battleships_exam.service;

import com.example.battleships_exam.model.dto.service.UserRegisterServiceModel;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerUser(UserRegisterServiceModel map);
}
