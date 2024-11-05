package com.example.gira.service;

import com.example.gira.model.dto.service.AddTaskServiceModel;
import com.example.gira.model.dto.view.TaskViewModel;

import java.util.Collection;

public interface TaskService {
  void addTask(AddTaskServiceModel map);

  boolean doesTaskNameExists(String taskName);

  Collection<TaskViewModel> findAllTasks();

  void updateTaskProgress(Long taskId);
}
