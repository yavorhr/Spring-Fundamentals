package com.example.ioc_demo;

import org.springframework.stereotype.Component;

@Component
public class LagerBeerMachine implements BeerMachineIfc {

  public LagerBeerMachine() {
  }

  @Override
  public String pourBeer() {
    return "Lager machine is pouring cold beer!";
  }
}
