package com.example.shopping_list_exam.model.entity;

import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
  private CategoryEnum name;

  public Category() {
  }

  @Column(unique = true,nullable = false)
  @Enumerated(EnumType.STRING)
  public CategoryEnum getName() {
    return name;
  }

  public Category setName(CategoryEnum categoryEnum) {
    this.name = categoryEnum;
    return this;
  }
}
