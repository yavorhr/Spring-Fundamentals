package com.example.musicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginLogoutController {

  @GetMapping("/users/login")
  public String getLoginPage() {
    return "login";
  }
}
