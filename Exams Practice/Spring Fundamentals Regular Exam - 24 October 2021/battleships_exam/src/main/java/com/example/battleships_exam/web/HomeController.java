package com.example.battleships_exam.web;

import com.example.battleships_exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  private final CurrentUser currentUser;

  public HomeController(CurrentUser currentUser) {
    this.currentUser = currentUser;
  }

  @GetMapping("/")
  public String indexPage() {
    return "index";
  }

  @GetMapping("/home")
  public String homePage() {

    if (!this.currentUser.isLoggedIn()) {
      return "redirect:/";
    }

    return "home";
  }
}
