package com.example.shopping_list_exam.model.binding;

import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import com.example.shopping_list_exam.validation.product.UniqueProductName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddProductBindingModel {
  private String name;
  private String description;
  private BigDecimal price;
  private LocalDateTime neededBefore;
  private CategoryEnum category;

  public AddProductBindingModel() {
  }

  @UniqueProductName
  @Size(min = 3, max = 20,message = "Name must be between 3 and 20 symbols")
  public String getName() {
    return name;
  }

  @Size(min = 5,message = "Description must be minimum 5 symbols")
  public String getDescription() {
    return description;
  }

  @Positive
  @NotNull
  public BigDecimal getPrice() {
    return price;
  }

  @NotNull(message ="Please add date")
  @FutureOrPresent(message = "Created date cannot be in the past")
  @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss")
  public LocalDateTime getNeededBefore() {
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

  public AddProductBindingModel setNeededBefore(LocalDateTime neededBefore) {
    this.neededBefore = neededBefore;
    return this;
  }

  public AddProductBindingModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }
}
