package com.example.gira.model.dto.binding;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.entity.enums.ClassificationEnum;
import com.example.gira.validation.addTask.UniqueTaskName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddTaskBindingModel {
  private String name;
  private String description;
  private LocalDate dueDate;
  private ClassificationEnum classificationEnum;

  public AddTaskBindingModel() {
  }

  @UniqueTaskName
  @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
  @NotEmpty(message = "Name is required")
  public String getName() {
    return name;
  }

  @Size(min = 5, message = "Description must be minimum 5 characters")
  @NotEmpty(message = "Description is required")
  public String getDescription() {
    return description;
  }

  @FutureOrPresent(message = "Date can't be in the past")
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  public LocalDate getDueDate() {
    return dueDate;
  }

  @NotNull
  public ClassificationEnum getClassificationEnum() {
    return classificationEnum;
  }

  public AddTaskBindingModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddTaskBindingModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public AddTaskBindingModel setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  public AddTaskBindingModel setClassificationEnum(ClassificationEnum classificationEnum) {
    this.classificationEnum = classificationEnum;
    return this;
  }
}
