package com.example.ioc_demo;

import org.springframework.stereotype.Component;

@Component
public class Bar {
  private final Bartender bartender;

  public Bar(Bartender bartender) {
    this.bartender = bartender;
  }

  public void work(){
    System.out.println(bartender.serveBeer());
  }
}
