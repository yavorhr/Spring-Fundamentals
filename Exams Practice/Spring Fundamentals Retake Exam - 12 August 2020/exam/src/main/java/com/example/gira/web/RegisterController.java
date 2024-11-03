package com.example.gira.web;

import com.example.gira.model.dto.binding.UserRegisterBindingModel;
import com.example.gira.model.dto.service.UserRegisterServiceModel;
import com.example.gira.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
  private final UserService userService;
  private final ModelMapper modelMapper;

  public RegisterController(UserService userService, ModelMapper modelMapper) {
    this.userService = userService;
    this.modelMapper = modelMapper;
  }

  @ModelAttribute("userRegisterBindingModel")
  public UserRegisterBindingModel userRegisterBindingModel() {
    return new UserRegisterBindingModel();
  }

  @GetMapping("/users/register")
  public String registerPage() {

    return "register";
  }

  @PostMapping("/users/register")
  public String registerUser(@Valid UserRegisterBindingModel userRegisterBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes
              .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

      return "redirect:register";
    }

    this.userService.registerUser(this.modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));

    return "redirect:login";
  }
}
