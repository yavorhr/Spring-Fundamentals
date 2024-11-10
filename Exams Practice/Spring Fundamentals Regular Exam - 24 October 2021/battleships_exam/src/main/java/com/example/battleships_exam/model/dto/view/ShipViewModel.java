package com.example.battleships_exam.model.dto.view;

public class ShipViewModel {
  private String name;
  private int health;
  private int power;

  public ShipViewModel() {
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

  public ShipViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public ShipViewModel setHealth(int health) {
    this.health = health;
    return this;
  }

  public ShipViewModel setPower(int power) {
    this.power = power;
    return this;
  }
}
