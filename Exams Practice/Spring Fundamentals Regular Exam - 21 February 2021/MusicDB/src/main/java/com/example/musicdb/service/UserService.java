package com.example.musicdb.service;

import com.example.musicdb.model.dto.service.UserLoginServiceModel;
import com.example.musicdb.model.entity.User;
import com.example.musicdb.model.dto.service.UserRegisterServiceModel;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public interface UserService {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  boolean isUsernameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerAndLoginUser(UserRegisterServiceModel serviceModel);

  boolean findByUsernameAndPassword(String username, String password);

  void loginUser(UserLoginServiceModel map);

  void logout();
}
