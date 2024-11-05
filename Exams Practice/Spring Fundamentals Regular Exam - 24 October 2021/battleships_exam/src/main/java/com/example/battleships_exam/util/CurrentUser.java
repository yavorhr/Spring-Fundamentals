package com.example.battleships_exam.util;

import com.example.battleships_exam.model.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser implements CurrentUserContext {
  private Long id;
  private String username;
  private String email;
  private String fullName;

  public CurrentUser() {
  }

  public String getFullName() {
    return fullName;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public CurrentUser setUsername(String username) {
    this.username = username;
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

  public CurrentUser setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  @Override
  public boolean isLoggedIn() {
    return this.id != null;
  }

  @Override
  public void saveSession(UserEntity userEntity) {
    this
            .setEmail(userEntity.getEmail())
            .setId(userEntity.getId())
            .setUsername(getUsername())
            .setFullName(userEntity.getFullName());
  }

  @Override
  public void logout() {
    this
            .setEmail("")
            .setId(null)
            .setUsername("")
            .setFullName("");
  }
}
