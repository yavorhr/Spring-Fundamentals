package com.example.musicdb.web;

import com.example.musicdb.model.dto.binding.UserLoginBindingModel;
import com.example.musicdb.model.dto.service.UserLoginServiceModel;
import com.example.musicdb.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserLoginLogoutController {
  private final UserService userService;
  private final ModelMapper mapper;

  public UserLoginLogoutController(UserService userService, ModelMapper mapper) {
    this.userService = userService;
    this.mapper = mapper;
  }

  @ModelAttribute("userLoginBindingModel")
  public UserLoginBindingModel userLoginBindingModel() {
    return new UserLoginBindingModel();
  }

  @GetMapping("/users/login")
  public String getLoginPage(Model model) {
    if (!model.containsAttribute("userNotExists")) {
      model.addAttribute("userNotExists", false);
    }
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

    boolean userIsPresent =
            this.userService.findByUsernameAndPassword(
                    userLoginBindingModel.getUsername(),
                    userLoginBindingModel.getPassword());

    if (!userIsPresent) {
      redirectAttributes
              .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult)
              .addFlashAttribute("userNotExists", true);

      return "redirect:login";
    }

    this.userService.loginUser(this.mapper.map(userLoginBindingModel, UserLoginServiceModel.class));

    return "redirect:/home";
  }
}
