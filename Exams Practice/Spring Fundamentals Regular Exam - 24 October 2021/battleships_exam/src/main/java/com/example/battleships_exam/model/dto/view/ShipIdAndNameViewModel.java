package com.example.battleships_exam.model.dto.view;

public class ShipIdAndNameViewModel {
  private Long id;
  private String name;

  public ShipIdAndNameViewModel() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public ShipIdAndNameViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public ShipIdAndNameViewModel setName(String name) {
    this.name = name;
    return this;
  }
}
