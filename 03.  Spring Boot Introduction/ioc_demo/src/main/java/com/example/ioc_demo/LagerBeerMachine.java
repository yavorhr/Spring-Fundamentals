package com.example.ioc_demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LagerBeerMachine implements BeerMachineIfc {

  public LagerBeerMachine() {
  }

  @Override
  public String pourBeer() {
    return "Lager machine is pouring cold beer!";
  }

  @PostConstruct
  public void postConstruct(){
    System.out.println("Lager machine is ready for action!");
  }

  @PreDestroy
  public void afterConstruct(){
    System.out.println("Lager machine needs to be cleaned!");
  }
}
