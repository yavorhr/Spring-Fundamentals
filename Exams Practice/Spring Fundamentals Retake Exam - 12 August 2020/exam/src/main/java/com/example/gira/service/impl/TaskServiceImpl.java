package com.example.gira.service.impl;

import com.example.gira.model.dto.service.AddTaskServiceModel;
import com.example.gira.model.entity.Task;
import com.example.gira.model.entity.enums.ProgressEnum;
import com.example.gira.repository.TaskRepository;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
  private final TaskRepository taskRepository;
  private final ModelMapper modelMapper;
  private final CurrentUser currentUser;
  private final UserServiceImpl userService;
  private final ClassificationService classificationService;

  public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, CurrentUser currentUser, UserServiceImpl userService, ClassificationService classificationService) {
    this.taskRepository = taskRepository;
    this.modelMapper = modelMapper;
    this.currentUser = currentUser;
    this.userService = userService;
    this.classificationService = classificationService;
  }

  @Override
  public void addTask(AddTaskServiceModel serviceModel) {
    Task entity = this.modelMapper.map(serviceModel, Task.class);
    entity.setUserEntity(this.userService.findById(this.currentUser.getId()).get());
    entity.setClassification(this.classificationService.findByName(serviceModel.getClassificationEnum()).get());
    entity.setProgress(ProgressEnum.OPEN);
  }

  @Override
  public boolean doesTaskNameExists(String taskName) {
    return this.taskRepository.findByName(taskName).isEmpty();
  }
}
