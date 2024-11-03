package com.example.gira.validation.addTask;

import com.example.gira.service.TaskService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueTaskNameValidator implements ConstraintValidator<UniqueTaskName, String> {
  private final TaskService taskService;

  public UniqueTaskNameValidator(TaskService taskService) {

    this.taskService = taskService;
  }

  @Override
  public boolean isValid(String taskName, ConstraintValidatorContext context) {
    if (taskName == null) {
      return true;
    }
    return taskService.doesTaskNameExists(taskName);
  }

}
