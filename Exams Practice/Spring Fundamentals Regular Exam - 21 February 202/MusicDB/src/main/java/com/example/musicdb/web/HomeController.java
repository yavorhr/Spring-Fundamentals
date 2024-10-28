package com.example.musicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String indexPage() {

    return "index";
  }

  @GetMapping("/home")
  public String homePage() {

    return "home";
  }
}
