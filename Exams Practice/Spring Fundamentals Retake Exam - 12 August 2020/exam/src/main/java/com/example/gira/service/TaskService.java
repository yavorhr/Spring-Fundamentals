package com.example.gira.service;

import com.example.gira.model.dto.service.AddTaskServiceModel;

public interface TaskService {
  void addTask(AddTaskServiceModel map);

  boolean doesTaskNameExists(String taskName);
}
