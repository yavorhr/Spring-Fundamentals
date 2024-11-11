package com.example.shopping_list_exam.web;

import com.example.shopping_list_exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  private final CurrentUser currentUser;

  public HomeController(CurrentUser currentUser) {
    this.currentUser = currentUser;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/home")
  public String home() {
    if (!this.currentUser.isLoggedIn()) {
      return "redirect:/";
    }
    return "home";
  }
}
