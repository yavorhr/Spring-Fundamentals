package com.example.battleships_exam.service.impl;

import com.example.battleships_exam.repository.ShipRepository;
import com.example.battleships_exam.service.ShipService;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
  private final ShipRepository shipRepository;

  public ShipServiceImpl(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  @Override
  public boolean doesShipExists(String name) {
    return this.shipRepository.findByName(name).isEmpty();
  }
}
