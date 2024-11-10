package com.example.shopping_list_exam.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
  private String username;
  private String password;
  private String email;

  public UserEntity() {
  }

  @Column(unique = true, nullable = false)
  public String getUsername() {
    return username;
  }

  @Column(nullable = false)
  public String getPassword() {
    return password;
  }

  @Column(unique = true, nullable = false)
  public String getEmail() {
    return email;
  }

  public UserEntity setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserEntity setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserEntity setEmail(String email) {
    this.email = email;
    return this;
  }
}
