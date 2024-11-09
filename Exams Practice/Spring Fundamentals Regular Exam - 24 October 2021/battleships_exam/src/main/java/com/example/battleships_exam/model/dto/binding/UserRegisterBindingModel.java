package com.example.battleships_exam.model.dto.binding;

import com.example.battleships_exam.validation.register.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
  private String username;
  private String fullName;
  private String email;
  private String password;
  private String confirmPassword;

  public UserRegisterBindingModel() {
  }

  @UniqueUsername
  @NotNull
  @Size(min = 3,max = 10)
  public String getUsername() {
    return username;
  }

  @NotNull
  @Size(min = 5,max = 20)
  public String getFullName() {
    return fullName;
  }

  @NotNull
  @Email
  public String getEmail() {
    return email;
  }

  @NotNull
  @Size(min = 3)
  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public UserRegisterBindingModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserRegisterBindingModel setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public UserRegisterBindingModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public UserRegisterBindingModel setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }
}
