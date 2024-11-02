package com.example.gira.model.dto.binding;

import com.example.gira.validation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
  private String username;
  private String password;
  private String email;

  public UserRegisterBindingModel() {
  }

  @UniqueUsername
  @NotNull
  @Size(min = 3,max = 20)
  public String getUsername() {
    return username;
  }

  @NotNull
  @Size(min = 3,max = 20)
  public String getPassword() {
    return password;
  }

  @Email
  @NotNull
  public String getEmail() {
    return email;
  }

  public UserRegisterBindingModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserRegisterBindingModel setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserRegisterBindingModel setEmail(String email) {
    this.email = email;
    return this;
  }
}
