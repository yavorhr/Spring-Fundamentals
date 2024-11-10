package com.example.musicdb.model.dto.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
  private String username;
  private String password;

  public UserLoginBindingModel() {
  }

  @Size(min = 3,max = 20)
  @NotNull
  public String getUsername() {
    return username;
  }

  @Size(min = 5,max = 20)
  @NotNull
  public String getPassword() {
    return password;
  }

  public UserLoginBindingModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserLoginBindingModel setPassword(String password) {
    this.password = password;
    return this;
  }
}
