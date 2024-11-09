package com.example.battleships_exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShipController {

  @GetMapping("/ships/add")
  public String addShipPage(){

    return "ship-add";
  }

  @PostMapping("/ships/add")
  public String addShip(){

    return "ship-add";
  }
}
