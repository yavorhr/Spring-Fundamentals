package com.example.battleships_exam.service;

import com.example.battleships_exam.model.dto.service.AddShipServiceModel;
import com.example.battleships_exam.model.dto.view.ShipIdAndNameViewModel;
import com.example.battleships_exam.model.dto.view.ShipViewModel;

import java.util.List;

public interface ShipService {
  boolean doesShipExists(String name);

  void addShip(AddShipServiceModel map);

  List<ShipIdAndNameViewModel> findShipsByUserId(Long id);

  List<ShipIdAndNameViewModel> findOtherShips(Long id);

  List<ShipViewModel> findAllShips();
}
