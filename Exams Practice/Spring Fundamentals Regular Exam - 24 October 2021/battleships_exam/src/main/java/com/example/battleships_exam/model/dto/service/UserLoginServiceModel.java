package com.example.battleships_exam.model.dto.service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginServiceModel {
  private String username;
  private String password;

  public UserLoginServiceModel() {
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public UserLoginServiceModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserLoginServiceModel setPassword(String password) {
    this.password = password;
    return this;
  }
}
