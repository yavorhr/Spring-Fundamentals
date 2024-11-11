package com.example.shopping_list_exam.util;

import com.example.shopping_list_exam.model.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser implements CurrentUserContext {
  private Long id;
  private String username;
  private String email;

  public CurrentUser() {
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

  @Override
  public boolean isLoggedIn() {
    return this.id != null;
  }

  @Override
  public void saveSession(UserEntity userEntity) {
    this
            .setEmail(userEntity.getEmail())
            .setId(userEntity.getId())
            .setUsername(getUsername());
  }

  @Override
  public void logout() {
    this
            .setEmail("")
            .setId(null)
            .setUsername("");
  }
}
