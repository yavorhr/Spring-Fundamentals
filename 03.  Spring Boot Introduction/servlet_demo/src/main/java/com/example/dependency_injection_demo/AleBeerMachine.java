package com.example.dependency_injection_demo;

public class AleBeerMachine implements BeerMachineIfc {

  public AleBeerMachine() {
  }

  @Override
  public String pourBeer() {
    return "Ale machine is pouring tasteful ale beer!";
  }
}
