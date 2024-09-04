package com.example.dependency_injection_demo;

public class Bar {
  private Bartender bartender;

  public Bar() {
    this.bartender = new Bartender(new LagerBeerMachine());
  }

  public void work() {
    bartender.serveBeer();
  }
}
