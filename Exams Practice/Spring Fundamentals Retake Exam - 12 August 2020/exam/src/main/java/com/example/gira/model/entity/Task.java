package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ProgressEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
  private String name;
  private String description;
  private ProgressEnum progress;
  private LocalDate dueDate;
  private Classification classification;
  private UserEntity userEntity;

  public Task() {
  }

  @Column(unique = true, nullable = false)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public String getDescription() {
    return description;
  }
  @Column(unique = true, nullable = false)
  public ProgressEnum getProgress() {
    return progress;
  }

  @Column(nullable = false, name = "due_date")
  public LocalDate getDueDate() {
    return dueDate;
  }

  @ManyToOne
  public Classification getClassification() {
    return classification;
  }

  @ManyToOne
  public UserEntity getUserEntity() {
    return userEntity;
  }

  public Task setName(String name) {
    this.name = name;
    return this;
  }

  public Task setDescription(String description) {
    this.description = description;
    return this;
  }

  public Task setProgress(ProgressEnum progress) {
    this.progress = progress;
    return this;
  }

  public Task setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  public Task setClassification(Classification classification) {
    this.classification = classification;
    return this;
  }

  public Task setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
    return this;
  }
}
