package com.example.battleships_exam.web;

import com.example.battleships_exam.model.dto.binding.AddShipBindingModel;
import com.example.battleships_exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShipController {
  private final CurrentUser currentUser;

  public ShipController(CurrentUser currentUser) {
    this.currentUser = currentUser;
  }

  @ModelAttribute("addShipBindingModel")
  public AddShipBindingModel addShipBindingModel(){
    return new AddShipBindingModel();
  }

  @GetMapping("/ships/add")
  public String addShipPage(){

    if (!this.currentUser.isLoggedIn()){
      return "redirect:/users/login";
    }

    return "ship-add";
  }

  @PostMapping("/ships/add")
  public String addShip(){

    return "ship-add";
  }
}
