package com.example.gira.web;

import com.example.gira.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  private final CurrentUser currentUser;

  public HomeController(CurrentUser currentUser) {
    this.currentUser = currentUser;
  }

  @GetMapping("/home")
  public String homePage() {

//    if (!currentUser.isLoggedIn()) {
//      return "redirect:/";
//    }

    return "home";
  }

  @GetMapping("/")
  public String indexPage() {


    return "index";
  }
}
