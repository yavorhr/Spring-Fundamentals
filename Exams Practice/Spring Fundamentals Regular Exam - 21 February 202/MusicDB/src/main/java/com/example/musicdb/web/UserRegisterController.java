package com.example.musicdb.web;

import com.example.musicdb.model.dto.binding.UserRegisterBindingModel;
import com.example.musicdb.model.dto.service.userRegisterServiceModel;
import com.example.musicdb.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegisterController {
  private final UserService userService;
  private final ModelMapper modelMapper;

  public UserRegisterController(UserService userService, ModelMapper modelMapper) {
    this.userService = userService;
    this.modelMapper = modelMapper;
  }

  @ModelAttribute("userRegisterBindingModel")
  public UserRegisterBindingModel registerBindingModel() {
    return new UserRegisterBindingModel();
  }

  @GetMapping("/users/register")
  public String getRegisterPage() {

    return "register";
  }

  @PostMapping("/users/register")
  public String registerUser(
          @Valid UserRegisterBindingModel userRegisterBindingModel,
          BindingResult bindingResult,
          RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors() ||
            !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

      redirectAttributes
              .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

      return "redirect:register";
    }

    boolean isUsernameAvailable = this.userService.isUsernameAvailable(userRegisterBindingModel.getUsername());
    boolean isEmailAvailable = this.userService.isEmailAvailable(userRegisterBindingModel.getEmail());

    if (!isEmailAvailable) {
      redirectAttributes
              .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult)
              .addFlashAttribute("emailAlreadyOccupied", true);

      return "redirect:register";
    }

    if (!isUsernameAvailable) {
      redirectAttributes
              .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult)
              .addFlashAttribute("usernameAlreadyOccupied", true);

      return "redirect:register";
    }

    this.userService.registerUser(this.modelMapper.map(userRegisterBindingModel, userRegisterServiceModel.class ));

    return "redirect:login";
  }
}


