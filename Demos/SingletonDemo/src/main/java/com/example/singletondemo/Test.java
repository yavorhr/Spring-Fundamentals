package com.example.singletondemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {
  private final TestBean testBean1;
  private final TestBean testBean2;
  private final TestConfig config;

  public Test(TestBean testBean1, TestBean testBean2, TestConfig config) {
    this.testBean1 = testBean1;
    this.testBean2 = testBean2;
    this.config = config;
  }


  public void run(String... args) throws Exception {
    testBean1.sayHello();
    testBean2.sayHello();
    config.testBean().sayHello();
    config.testBean().sayHello();
  }
}

