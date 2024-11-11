package com.example.shopping_list_exam.service;

import com.example.shopping_list_exam.model.service.UserLoginServiceModel;
import com.example.shopping_list_exam.model.service.UserRegisterServiceModel;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  void registerUser(UserRegisterServiceModel serviceModel);

  void loginUser(UserLoginServiceModel serviceModel);

  boolean doesUserExist(UserLoginServiceModel map);

  void logout();
}
