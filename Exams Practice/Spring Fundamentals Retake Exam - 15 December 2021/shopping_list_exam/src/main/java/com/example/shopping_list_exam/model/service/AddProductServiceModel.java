package com.example.shopping_list_exam.model.service;

import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import com.example.shopping_list_exam.validation.product.UniqueProductName;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddProductServiceModel {
  private String name;
  private String description;
  private BigDecimal price;
  private LocalDate neededBefore;
  private CategoryEnum category;

  public AddProductServiceModel() {
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public LocalDate getNeededBefore() {
    return neededBefore;
  }

  public CategoryEnum getCategory() {
    return category;
  }

  public AddProductServiceModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddProductServiceModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public AddProductServiceModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public AddProductServiceModel setNeededBefore(LocalDate neededBefore) {
    this.neededBefore = neededBefore;
    return this;
  }

  public AddProductServiceModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }
}
