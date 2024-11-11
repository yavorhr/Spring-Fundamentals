package com.example.shopping_list_exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

  @GetMapping("/users/register")
  public String register() {
    return "register";
  }
}
