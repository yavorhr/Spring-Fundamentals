package com.example.gira.model.dto.service;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.entity.enums.ClassificationEnum;

import java.time.LocalDate;

public class AddTaskServiceModel {
  private String name;
  private String description;
  private LocalDate dueDate;
  private ClassificationEnum classificationEnum;

  public AddTaskServiceModel() {
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public ClassificationEnum getClassificationEnum() {
    return classificationEnum;
  }

  public AddTaskServiceModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddTaskServiceModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public AddTaskServiceModel setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  public AddTaskServiceModel setClassificationEnum(ClassificationEnum classificationEnum) {
    this.classificationEnum = classificationEnum;
    return this;
  }
}
