package com.example.gira.service;

import com.example.gira.model.dto.service.UserLoginServiceModel;
import com.example.gira.model.dto.service.UserRegisterServiceModel;
import com.example.gira.model.entity.UserEntity;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerUser(UserRegisterServiceModel serviceModel);

  boolean doesUserExist(UserLoginServiceModel map);

  void loginUser(UserLoginServiceModel map);

  void logout();

  Optional<UserEntity> findById(Long id);
}
