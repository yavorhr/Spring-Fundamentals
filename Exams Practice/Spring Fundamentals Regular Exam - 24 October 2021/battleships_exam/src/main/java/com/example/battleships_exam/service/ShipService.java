package com.example.battleships_exam.service;

import com.example.battleships_exam.model.dto.service.AddShipServiceModel;

public interface ShipService {
  boolean doesShipExists(String name);

  void addShip(AddShipServiceModel map);
}
