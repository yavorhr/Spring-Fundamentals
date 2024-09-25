package com.example.singletondemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

  @Bean
  public TestBean testBean() {
    return instantiate();
  }

  private TestBean instantiate() {
    return new TestBean();
  }
}
