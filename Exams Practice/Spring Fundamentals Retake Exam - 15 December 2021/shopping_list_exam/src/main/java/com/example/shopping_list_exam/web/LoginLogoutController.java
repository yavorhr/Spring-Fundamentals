package com.example.shopping_list_exam.web;

import com.example.shopping_list_exam.model.binding.UserLoginBindingModel;
import com.example.shopping_list_exam.model.service.UserLoginServiceModel;
import com.example.shopping_list_exam.service.UserService;
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
  private final UserService userService;
  private final ModelMapper modelMapper;

  public LoginLogoutController(UserService userService, ModelMapper modelMapper) {
    this.userService = userService;
    this.modelMapper = modelMapper;
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
