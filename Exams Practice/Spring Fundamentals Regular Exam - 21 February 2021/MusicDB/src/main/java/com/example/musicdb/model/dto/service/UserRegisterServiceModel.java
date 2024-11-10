package com.example.musicdb.model.dto.service;

public class UserRegisterServiceModel {
  private String username;
  private String fullName;
  private String email;
  private String password;

  public UserRegisterServiceModel() {
  }

  public String getUsername() {
    return username;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public UserRegisterServiceModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserRegisterServiceModel setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public UserRegisterServiceModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public UserRegisterServiceModel setPassword(String password) {
    this.password = password;
    return this;
  }
}
