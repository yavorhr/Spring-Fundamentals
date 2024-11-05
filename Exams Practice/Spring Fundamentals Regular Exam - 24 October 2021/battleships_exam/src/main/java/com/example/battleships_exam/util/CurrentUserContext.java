package com.example.battleships_exam.util;

import com.example.battleships_exam.model.entity.UserEntity;

public interface CurrentUserContext {

  boolean isLoggedIn();

  void saveSession(UserEntity userEntity);

  void logout();

}
