package com.example.gira.model.dto.binding;

import com.example.gira.model.entity.enums.ClassificationEnum;
import com.example.gira.validation.addTask.UniqueTaskName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddTaskBindingModel {
  private String name;
  private String description;
  private LocalDate dueDate;
  private ClassificationEnum classification;

  public AddTaskBindingModel() {
  }

  @UniqueTaskName
  @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
  public String getName() {
    return name;
  }

  @Size(min = 5, message = "Description must be minimum 5 characters")
  public String getDescription() {
    return description;
  }

  @FutureOrPresent(message = "Due date can't be in the past")
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  public LocalDate getDueDate() {
    return dueDate;
  }

  @NotNull
  public ClassificationEnum getClassification() {
    return classification;
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

  public AddTaskBindingModel setClassification(ClassificationEnum classification) {
    this.classification = classification;
    return this;
  }
}
