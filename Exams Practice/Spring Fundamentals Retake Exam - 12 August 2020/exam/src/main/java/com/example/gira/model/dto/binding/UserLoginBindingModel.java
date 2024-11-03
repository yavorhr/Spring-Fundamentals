package com.example.gira.model.dto.binding;

import com.example.gira.validation.login.DoesUserExist;
import jakarta.validation.constraints.NotBlank;

@DoesUserExist
public class UserLoginBindingModel {
  private String email;
  private String password;

  public UserLoginBindingModel() {
  }

  @NotBlank(message = "Email is required")
  public String getEmail() {
    return email;
  }

  public UserLoginBindingModel setEmail(String email) {
    this.email = email;
    return this;
  }

  @NotBlank(message = "Password is required")
  public String getPassword() {
    return password;
  }

  public UserLoginBindingModel setPassword(String password) {
    this.password = password;
    return this;
  }
}
