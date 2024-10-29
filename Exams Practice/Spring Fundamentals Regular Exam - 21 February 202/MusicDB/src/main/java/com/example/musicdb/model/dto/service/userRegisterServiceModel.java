package com.example.musicdb.model.dto.service;

public class userRegisterServiceModel {
  private String username;
  private String fullName;
  private String email;
  private String password;

  public userRegisterServiceModel() {
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

  public userRegisterServiceModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public userRegisterServiceModel setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public userRegisterServiceModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public userRegisterServiceModel setPassword(String password) {
    this.password = password;
    return this;
  }
}
