package com.example.battleships_exam.service;

public interface UserService {
  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);
}
