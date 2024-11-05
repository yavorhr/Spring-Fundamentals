package com.example.battleships_exam.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
  private String username;
  private String fullName;
  private String password;
  private String email;

  public UserEntity() {
  }

  @Column(unique = true, nullable = false)
  @Size(min = 3, max = 10)
  public String getUsername() {
    return username;
  }

  @Column(name = "full_name", nullable = false)
  @Size(min = 5, max = 20)
  public String getFullName() {
    return fullName;
  }

  @Column(nullable = false)
  @Size(min = 3)
  public String getPassword() {
    return password;
  }

  @Column(unique = true, nullable = false)
  @Email
  public String getEmail() {
    return email;
  }

  public UserEntity setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserEntity setFullName(String fullName) {
    this.fullName = fullName;
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
