package com.example.battleships_exam.web;

import com.example.battleships_exam.model.dto.binding.UserLoginBindingModel;
import com.example.battleships_exam.model.dto.service.UserLoginServiceModel;
import com.example.battleships_exam.repository.UserRepository;
import com.example.battleships_exam.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginLogoutController {
  private final ModelMapper modelMapper;
  private final UserService userService;

  public LoginLogoutController(ModelMapper modelMapper, UserService userService) {
    this.modelMapper = modelMapper;
    this.userService = userService;
  }

  @ModelAttribute("userLoginBindingModel")
  public UserLoginBindingModel userLoginBindingModel() {
    return new UserLoginBindingModel();
  }

  @GetMapping("/users/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/users/login")
  public String loginUser(@Valid UserLoginBindingModel userLoginBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes
              .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

      return "redirect:login";
    }

    this.userService.loginUser(this.modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));

    return "redirect:/home";
  }
}
