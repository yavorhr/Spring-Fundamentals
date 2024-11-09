package com.example.battleships_exam.model.dto.service;

import com.example.battleships_exam.model.entity.enums.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddShipServiceModel {
  private String name;
  private int health;
  private int power;
  private LocalDate created;
  private CategoryEnum category;

  public AddShipServiceModel() {
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public int getPower() {
    return power;
  }

  public LocalDate getCreated() {
    return created;
  }

  public CategoryEnum getCategory() {
    return category;
  }

  public AddShipServiceModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddShipServiceModel setHealth(int health) {
    this.health = health;
    return this;
  }

  public AddShipServiceModel setPower(int power) {
    this.power = power;
    return this;
  }

  public AddShipServiceModel setCreated(LocalDate created) {
    this.created = created;
    return this;
  }

  public AddShipServiceModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }

}
