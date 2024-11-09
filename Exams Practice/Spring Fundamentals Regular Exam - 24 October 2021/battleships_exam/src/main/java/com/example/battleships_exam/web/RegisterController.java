package com.example.battleships_exam.web;

import com.example.battleships_exam.model.dto.binding.UserRegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegisterController {

  @ModelAttribute("userRegisterBindingModel")
  public UserRegisterBindingModel userRegisterBindingModel() {
    return new UserRegisterBindingModel();
  }

  @GetMapping("/users/register")
  public String registerPage() {
    return "register";
  }
}
