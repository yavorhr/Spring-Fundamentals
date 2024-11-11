package com.example.shopping_list_exam.util;

import com.example.shopping_list_exam.model.entity.UserEntity;

public interface CurrentUserContext {

  boolean isLoggedIn();

  void saveSession(UserEntity userEntity);

  void logout();

}
