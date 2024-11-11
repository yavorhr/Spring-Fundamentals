package com.example.shopping_list_exam.service;

import com.example.shopping_list_exam.model.service.UserRegisterServiceModel;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerUser(UserRegisterServiceModel map);
}
