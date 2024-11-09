package com.example.battleships_exam.validation.ship;

import com.example.battleships_exam.service.ShipService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueShipNameValidator implements ConstraintValidator<UniqueShipName, String> {
  private final ShipService shipService;

  public UniqueShipNameValidator(ShipService shipService) {
    this.shipService = shipService;
  }

  @Override
  public boolean isValid(String shipsName, ConstraintValidatorContext context) {
    if (shipsName == null) {
      return true;
    }
    return this.shipService.doesShipExists(shipsName);
  }

}
