package com.example.ioc_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public AleBeerMachine aleBeerMachine(){
    return new AleBeerMachine();
  }
}
