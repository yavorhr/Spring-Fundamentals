package com.example.shopping_list_exam.web;

import com.example.shopping_list_exam.service.ProductService;
import com.example.shopping_list_exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  private final CurrentUser currentUser;
  private final ProductService productService;

  public HomeController(CurrentUser currentUser, ProductService productService) {
    this.currentUser = currentUser;
    this.productService = productService;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/home")
  public String home(Model model) {
    if (!this.currentUser.isLoggedIn()) {
      return "redirect:/";
    }

    model.addAttribute("products",  this.productService.findAllProductsByUser(this.currentUser.getId()));
    model.addAttribute("totalPrice", this.productService.getTotalPriceOfProducts());

    return "home";
  }
}
