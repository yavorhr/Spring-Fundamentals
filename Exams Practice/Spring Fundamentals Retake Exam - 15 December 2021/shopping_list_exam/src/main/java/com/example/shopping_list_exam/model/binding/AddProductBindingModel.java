package com.example.shopping_list_exam.model.binding;

import com.example.shopping_list_exam.model.entity.Category;
import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import com.example.shopping_list_exam.validation.product.UniqueProductName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddProductBindingModel {
  private String name;
  private String description;
  private BigDecimal price;
  private LocalDate neededBefore;
  private CategoryEnum category;

  public AddProductBindingModel() {
  }

  @UniqueProductName
  @Size(min = 3, max = 20)
  public String getName() {
    return name;
  }

  @Size(min = 3,max = 20)
  public String getDescription() {
    return description;
  }

  @Positive
  @NotNull
  public BigDecimal getPrice() {
    return price;
  }

  @NotNull
  @FutureOrPresent(message = "Created date cannot be in the past")
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  public LocalDate getNeededBefore() {
    return neededBefore;
  }

  @NotNull
  public CategoryEnum getCategory() {
    return category;
  }

  public AddProductBindingModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddProductBindingModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public AddProductBindingModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public AddProductBindingModel setNeededBefore(LocalDate neededBefore) {
    this.neededBefore = neededBefore;
    return this;
  }

  public AddProductBindingModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }
}
