package com.example.battleships_exam.model.dto.binding;

import com.example.battleships_exam.model.entity.enums.CategoryEnum;
import com.example.battleships_exam.validation.ship.UniqueShipName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class AddShipBindingModel {
  private String name;
  private int health;
  private int power;
  private LocalDate created;
  private CategoryEnum category;

  public AddShipBindingModel() {
  }

  @UniqueShipName
  @NotNull
  @Size(min = 2,max = 10, message = "Name must be between 2 and 10 characters")
  public String getName() {
    return name;
  }

  @NotNull
  @Positive
  public int getHealth() {
    return health;
  }

  @NotNull
  @Positive
  public int getPower() {
    return power;
  }

  @PastOrPresent(message = "Creation date can't be in the future")
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  public LocalDate getCreated() {
    return created;
  }

  public CategoryEnum getCategory() {
    return category;
  }

  public AddShipBindingModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddShipBindingModel setHealth(int health) {
    this.health = health;
    return this;
  }

  public AddShipBindingModel setPower(int power) {
    this.power = power;
    return this;
  }

  public AddShipBindingModel setCreated(LocalDate created) {
    this.created = created;
    return this;
  }

  public AddShipBindingModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }

}
