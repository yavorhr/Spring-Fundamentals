package com.example.dependency_injection_demo;

public class LagerBeerMachine implements BeerMachineIfc {

  public LagerBeerMachine() {
  }

  @Override
  public String pourBeer() {
    return "Lager machine is pouring cold beer!";
  }
}
