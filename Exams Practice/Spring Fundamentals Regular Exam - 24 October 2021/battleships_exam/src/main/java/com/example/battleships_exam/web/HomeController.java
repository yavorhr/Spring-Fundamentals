package com.example.battleships_exam.web;

import com.example.battleships_exam.service.ShipService;
import com.example.battleships_exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  private final CurrentUser currentUser;
  private final ShipService shipService;

  public HomeController(CurrentUser currentUser, ShipService shipService) {
    this.currentUser = currentUser;
    this.shipService = shipService;
  }

  @GetMapping("/")
  public String indexPage() {
    return "index";
  }

  @GetMapping("/home")
  public String homePage(Model model) {

    if (!this.currentUser.isLoggedIn()) {
      return "redirect:/";
    }
    model.addAttribute("attackerShips", shipService.findShipsByUserId(this.currentUser.getId()));
    model.addAttribute("defenderShips", shipService.findOtherShips(this.currentUser.getId()));
    model.addAttribute("allShips", shipService.findAllShips());

    return "home";
  }
}
