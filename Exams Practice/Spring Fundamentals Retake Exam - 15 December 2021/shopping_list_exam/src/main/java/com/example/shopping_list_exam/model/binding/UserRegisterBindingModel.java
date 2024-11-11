package com.example.shopping_list_exam.model.binding;

import com.example.shopping_list_exam.validation.register.PasswordsMatchOnRegister;
import com.example.shopping_list_exam.validation.register.UniqueEmail;
import com.example.shopping_list_exam.validation.register.UniqueUsername;
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
  @Size(min = 3,max = 20, message = "Username must be between 3 and 20 symbols")
  public String getUsername() {
    return username;
  }

  @NotNull
  @Size(min = 3,max = 20)
  public String getPassword() {
    return password;
  }

  @UniqueEmail
  @NotBlank(message = "Please enter email")
  @Email
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
