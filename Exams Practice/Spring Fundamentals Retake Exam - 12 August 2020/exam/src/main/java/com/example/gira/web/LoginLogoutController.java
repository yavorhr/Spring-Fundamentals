package com.example.gira.web;

import com.example.gira.model.dto.binding.UserLoginBindingModel;
import com.example.gira.model.dto.service.UserLoginServiceModel;
import com.example.gira.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
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

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
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

  @GetMapping("/logout")
  public String logout(HttpSession httpSession) {
    httpSession.invalidate();
    userService.logout();

    return "redirect:/";
  }

}
