package com.example.gira.web;

import com.example.gira.model.dto.binding.AddTaskBindingModel;
import com.example.gira.model.dto.service.AddTaskServiceModel;
import com.example.gira.model.entity.enums.ClassificationEnum;
import com.example.gira.service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {
  private final TaskService taskService;
  private final ModelMapper modelMapper;

  public TaskController(TaskService taskService, ModelMapper modelMapper) {
    this.taskService = taskService;
    this.modelMapper = modelMapper;
  }

  @ModelAttribute("addTaskBindingModel")
  public AddTaskBindingModel addTaskBindingModel() {
    return new AddTaskBindingModel();
  }

  @ModelAttribute("classifications")
  public ClassificationEnum[] classificationEnums() {
    return ClassificationEnum.values();
  }

  @GetMapping("/tasks/add")
  public String addTaskPage() {

    return "add-task";
  }

  @PostMapping("/tasks/add")
  public String addTask(@Valid AddTaskBindingModel addTaskBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes
              .addFlashAttribute("addTaskBindingModel", addTaskBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.addTaskBindingModel", bindingResult);

      return "redirect:add";
    }

    this.taskService.addTask(modelMapper.map(addTaskBindingModel, AddTaskServiceModel.class));

    return "redirect:/home";
  }
}
