package com.example.musicdb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String username;
  private String fullName;
  private String password;
  private String email;

  public User() {
  }

  @Column(unique = true, nullable = false)
  public String getUsername() {
    return username;
  }

  public String getFullName() {
    return fullName;
  }

  @Column(nullable = false)
  public String getPassword() {
    return password;
  }

  @Column(unique = true, nullable = false)
  public String getEmail() {
    return email;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public User setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }
}
