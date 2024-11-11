package com.example.shopping_list_exam.model.binding;

import com.example.shopping_list_exam.validation.login.DoesUserExist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@DoesUserExist
public class UserLoginBindingModel {
  private String username;
  private String password;

  public UserLoginBindingModel() {
  }

  @NotNull
  @Size(min = 3,max = 20)
  public String getUsername() {
    return username;
  }

  @NotNull
  @Size(min = 3, max = 20)
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
