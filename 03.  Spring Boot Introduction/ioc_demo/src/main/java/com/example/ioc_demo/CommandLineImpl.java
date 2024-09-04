package com.example.ioc_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineImpl implements CommandLineRunner {
  private final Bar bar;

  public CommandLineImpl(Bar bar) {
    this.bar = bar;
  }

  @Override
  public void run(String... args) throws Exception {
    this.bar.work();
  }
}
