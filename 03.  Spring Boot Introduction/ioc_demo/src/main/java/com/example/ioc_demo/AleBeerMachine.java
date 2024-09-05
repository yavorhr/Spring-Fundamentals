package com.example.ioc_demo;

import org.springframework.stereotype.Component;

@Component("aleBeerMachineCustomName")
public class AleBeerMachine implements BeerMachineIfc {

  public AleBeerMachine() {
  }

  @Override
  public String pourBeer() {
    return "Ale machine is pouring tasteful ale beer!";
  }
}
