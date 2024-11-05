package com.example.battleships_exam.model.entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {
  private String name;
  private int health;
  private int power;
  private LocalDate created;
  private Category category;
  private UserEntity user;

  public Ship() {
  }

  @Column(nullable = false,unique = true)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public int getHealth() {
    return health;
  }

  @Column(nullable = false)
  public int getPower() {
    return power;
  }

  public LocalDate getCreated() {
    return created;
  }

  @ManyToOne
  public Category getCategory() {
    return category;
  }

  @ManyToOne
  public UserEntity getUser() {
    return user;
  }

  public Ship setName(String name) {
    this.name = name;
    return this;
  }

  public Ship setHealth(int health) {
    this.health = health;
    return this;
  }

  public Ship setPower(int power) {
    this.power = power;
    return this;
  }

  public Ship setCreated(LocalDate created) {
    this.created = created;
    return this;
  }

  public Ship setCategory(Category category) {
    this.category = category;
    return this;
  }

  public Ship setUser(UserEntity user) {
    this.user = user;
    return this;
  }

  @PrePersist
  public void setCreationDate(){
    this.created = LocalDate.now();
  }
}
