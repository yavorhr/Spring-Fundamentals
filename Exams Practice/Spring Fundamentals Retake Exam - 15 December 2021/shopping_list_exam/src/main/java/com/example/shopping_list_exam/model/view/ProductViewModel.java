package com.example.shopping_list_exam.model.view;

import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;

public class ProductViewModel {
  private Long id;
  private String name;
  private BigDecimal price;
  private CategoryEnum categoryEnum;

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

  public CategoryEnum getCategoryEnum() {
    return categoryEnum;
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

  public ProductViewModel setCategoryEnum(CategoryEnum categoryEnum) {
    this.categoryEnum = categoryEnum;
    return this;
  }
}
