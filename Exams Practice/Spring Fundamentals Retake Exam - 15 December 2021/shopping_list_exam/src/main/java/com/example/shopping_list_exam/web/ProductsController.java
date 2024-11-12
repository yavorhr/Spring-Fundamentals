package com.example.shopping_list_exam.web;

import com.example.shopping_list_exam.model.binding.AddProductBindingModel;
import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import com.example.shopping_list_exam.model.service.AddProductServiceModel;
import com.example.shopping_list_exam.service.ProductService;
import com.example.shopping_list_exam.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductsController {
  private final CurrentUser currentUser;
  private final ProductService productService;
  private final ModelMapper modelMapper;

  public ProductsController(CurrentUser currentUser, ProductService productService, ModelMapper modelMapper) {
    this.currentUser = currentUser;
    this.productService = productService;
    this.modelMapper = modelMapper;
  }

  @ModelAttribute("addProductBindingModel")
  public AddProductBindingModel addProductBindingModel(){
    return new AddProductBindingModel();
  }

  @ModelAttribute("categories")
  public CategoryEnum[] categories(){
    return CategoryEnum.values();
  }

  @GetMapping("/products/add")
  public String addProductPage(){

    if (!this.currentUser.isLoggedIn()){
      return "redirect:/users/login";
    }

    return "product-add";
  }

  @PostMapping("/products/add")
  public String addShip(@Valid AddProductBindingModel addProductBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

    if (bindingResult.hasErrors()) {
      redirectAttributes
              .addFlashAttribute("addProductBindingModel", addProductBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.addProductBindingModel", bindingResult);

      return "redirect:add";
    }

    this.productService.addProduct(this.modelMapper.map(addProductBindingModel, AddProductServiceModel.class));

    return "redirect:/home";
  }

}
