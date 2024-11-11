package com.example.shopping_list_exam.validation.product;

import com.example.shopping_list_exam.service.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueProductName, String> {
  private final ProductService productService;

  public UniqueNameValidator(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext context) {
    if (name == null || name.isBlank()) {
      return true;
    }
    return this.productService.doesProductExists(name);
  }
}
