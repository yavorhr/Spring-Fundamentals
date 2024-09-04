package com.example.ioc_demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bartender {
  private final BeerMachineIfc beerMachine;

  // Default constructor
  public Bartender(@Qualifier("aleBeerMachine") BeerMachineIfc beerMachine) {
    this.beerMachine = beerMachine;
  }

  // Example method that uses the beerMachine dependency
  public String serveBeer() {
    return  beerMachine.pourBeer();
  }
}