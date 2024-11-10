package com.example.battleships_exam.web;

import com.example.battleships_exam.model.dto.binding.AddShipBindingModel;
import com.example.battleships_exam.model.dto.service.AddShipServiceModel;
import com.example.battleships_exam.model.entity.enums.CategoryEnum;
import com.example.battleships_exam.service.ShipService;
import com.example.battleships_exam.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {
  private final CurrentUser currentUser;
  private final ShipService shipService;
  private final ModelMapper modelMapper;

  public ShipController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper) {
    this.currentUser = currentUser;
    this.shipService = shipService;
    this.modelMapper = modelMapper;
  }

  @ModelAttribute("addShipBindingModel")
  public AddShipBindingModel addShipBindingModel(){
    return new AddShipBindingModel();
  }

  @ModelAttribute("categories")
  public CategoryEnum[] categories(){
    return CategoryEnum.values();
  }

  @GetMapping("/ships/add")
  public String addShipPage(){

    if (!this.currentUser.isLoggedIn()){
      return "redirect:/users/login";
    }

    return "ship-add";
  }

  @PostMapping("/ships/add")
  public String addShip(@Valid AddShipBindingModel addShipBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

    if (bindingResult.hasErrors()) {
      redirectAttributes
              .addFlashAttribute("addShipBindingModel", addShipBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.addShipBindingModel", bindingResult);

      return "redirect:add";
    }

    this.shipService.addShip(this.modelMapper.map(addShipBindingModel, AddShipServiceModel.class));

    return "redirect:/home";
  }

  @PatchMapping("/ships/fire")
  public String fireShips(@RequestParam String attacker,
                          @RequestParam String defender){

   this.shipService.startFight(attacker,defender);

    return "redirect:/home";
  }
}
