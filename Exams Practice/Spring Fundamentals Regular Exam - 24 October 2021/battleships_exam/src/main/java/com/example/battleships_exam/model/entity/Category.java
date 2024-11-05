package com.example.battleships_exam.model.entity;

import com.example.battleships_exam.model.entity.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
  private CategoryEnum name;
  private String description;

  public Category() {
  }

  @Enumerated(EnumType.ORDINAL)
  @Column(unique = true,nullable = false)
  public CategoryEnum getName() {
    return name;
  }

  @Column(nullable = false, columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  public Category setName(CategoryEnum name) {
    this.name = name;
    return this;
  }

  public Category setDescription(String description) {
    this.description = description;
    return this;
  }
}
