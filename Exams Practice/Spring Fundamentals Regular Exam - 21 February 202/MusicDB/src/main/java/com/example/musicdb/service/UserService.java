package com.example.musicdb.service;

import com.example.musicdb.model.entity.User;
import com.example.musicdb.model.dto.service.UserRegisterServiceModel;

import java.util.Optional;

public interface UserService {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  boolean isUsernameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerAndLoginUser(UserRegisterServiceModel serviceModel);
}
