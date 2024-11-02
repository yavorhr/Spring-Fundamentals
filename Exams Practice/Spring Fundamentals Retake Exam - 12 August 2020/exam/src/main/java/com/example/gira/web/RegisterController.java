package com.example.gira.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

  @GetMapping("/users/register")
  public String registerPage() {


    return "register";
  }
}
