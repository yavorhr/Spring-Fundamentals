package com.example.gira.model.dto.view;

import com.example.gira.model.entity.enums.ClassificationEnum;
import com.example.gira.model.entity.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {
  private Long taskId;
  private String name;
  private String user;
  private ClassificationEnum classification;
  private String description;
  private ProgressEnum progress;
  private LocalDate dueDate;

  public TaskViewModel() {
  }

  public Long getTaskId() {
    return taskId;
  }

  public String getName() {
    return name;
  }

  public String getUser() {
    return user;
  }

  public ClassificationEnum getClassification() {
    return classification;
  }

  public String getDescription() {
    return description;
  }

  public ProgressEnum getProgress() {
    return progress;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public TaskViewModel setTaskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

  public TaskViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public TaskViewModel setUser(String user) {
    this.user = user;
    return this;
  }

  public TaskViewModel setClassification(ClassificationEnum classification) {
    this.classification = classification;
    return this;
  }

  public TaskViewModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public TaskViewModel setProgress(ProgressEnum progress) {
    this.progress = progress;
    return this;
  }

  public TaskViewModel setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    return this;
  }
}
