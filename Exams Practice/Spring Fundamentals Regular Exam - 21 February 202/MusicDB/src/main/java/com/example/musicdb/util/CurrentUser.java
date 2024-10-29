package com.example.musicdb.util;

import com.example.musicdb.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
  private Long id;
  private String username;
  private String fullName;
  private String password;
  private String email;

  public CurrentUser() {
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public CurrentUser setUsername(String username) {
    this.username = username;
    return this;
  }

  public CurrentUser setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public CurrentUser setPassword(String password) {
    this.password = password;
    return this;
  }

  public CurrentUser setEmail(String email) {
    this.email = email;
    return this;
  }

  public CurrentUser setId(Long id) {
    this.id = id;
    return this;
  }

  public void login(User userEntity) {
    this
            .setUsername(userEntity.getUsername())
            .setEmail(userEntity.getEmail())
            .setFullName(userEntity.getFullName());
  }

  public void clear() {
    this
            .setUsername("")
            .setEmail("")
            .setFullName("");
  }

  public boolean isLoggedIn() {
    return this.id != null;
  }
}
