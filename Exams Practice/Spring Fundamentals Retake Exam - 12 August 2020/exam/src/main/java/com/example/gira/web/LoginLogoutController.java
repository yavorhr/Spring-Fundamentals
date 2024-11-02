package com.example.gira.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {

  @GetMapping("/users/login")
  public String loginPage() {


    return "login";
  }
}
