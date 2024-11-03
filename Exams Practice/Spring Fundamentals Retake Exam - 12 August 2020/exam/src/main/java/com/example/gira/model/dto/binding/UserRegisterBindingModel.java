package com.example.gira.model.dto.binding;

import com.example.gira.validation.PasswordsMatchOnRegister;
import com.example.gira.validation.UniqueEmail;
import com.example.gira.validation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordsMatchOnRegister
public class UserRegisterBindingModel {
  private String username;
  private String password;
  private String confirmPassword;
  private String email;

  public UserRegisterBindingModel() {
  }

  @UniqueUsername
  @NotNull
  @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
  public String getUsername() {
    return username;
  }

  @NotNull
  @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
  public String getPassword() {
    return password;
  }

  @Email(message = "Please enter valid email address")
  @NotBlank(message = "Email is required")
  @UniqueEmail
  public String getEmail() {
    return email;
  }

  public String getConfirmPassword() {
    return confirmPassword;
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

  public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }
}
