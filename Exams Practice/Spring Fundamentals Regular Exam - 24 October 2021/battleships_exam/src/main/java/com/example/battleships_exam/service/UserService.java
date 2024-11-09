package com.example.battleships_exam.service;

import com.example.battleships_exam.model.dto.service.UserLoginServiceModel;
import com.example.battleships_exam.model.dto.service.UserRegisterServiceModel;
import com.example.battleships_exam.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerUser(UserRegisterServiceModel map);

  boolean doesUserExist(UserLoginServiceModel map);

  void loginUser(UserLoginServiceModel map);

  Optional<UserEntity> findUserById(Long id);
}
