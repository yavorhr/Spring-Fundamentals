package com.example.shopping_list_exam.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
  private String name;
  private String description;
  private BigDecimal price;
  private LocalDate neededBefore;
  private Category category;
  private UserEntity user;

  public Product() {
  }

  @ManyToOne
  public UserEntity getUser() {
    return user;
  }

  @Column(unique = true,nullable = false)
  public String getName() {
    return name;
  }

  @Column(nullable = false, columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  @Column(nullable = false)
  public BigDecimal getPrice() {
    return price;
  }

  @Column(nullable = false)
  public LocalDate getNeededBefore() {
    return neededBefore;
  }

  @ManyToOne
  public Category getCategory() {
    return category;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public Product setDescription(String description) {
    this.description = description;
    return this;
  }

  public Product setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public Product setNeededBefore(LocalDate neededBefore) {
    this.neededBefore = neededBefore;
    return this;
  }

  public Product setCategory(Category category) {
    this.category = category;
    return this;
  }

  public Product setUser(UserEntity user) {
    this.user = user;
    return this;
  }
}
