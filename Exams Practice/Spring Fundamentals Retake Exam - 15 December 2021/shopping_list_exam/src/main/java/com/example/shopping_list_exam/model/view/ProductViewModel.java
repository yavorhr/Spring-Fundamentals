package com.example.shopping_list_exam.model.view;

import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;

public class ProductViewModel {
  private Long id;
  private String name;
  private BigDecimal price;
  private CategoryEnum category;

  public ProductViewModel() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public CategoryEnum getCategory() {
    return category;
  }

  public ProductViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public ProductViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public ProductViewModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public ProductViewModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }
}
