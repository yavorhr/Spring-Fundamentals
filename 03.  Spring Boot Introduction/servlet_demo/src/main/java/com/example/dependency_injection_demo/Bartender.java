package com.example.dependency_injection_demo;

public class Bartender {

  private BeerMachineIfc beerMachine;

  public Bartender(BeerMachineIfc beerMachine) {
    this.beerMachine = beerMachine;
  }

  public void serveBeer() {
    System.out.println(beerMachine.pourBeer());
  }
}
