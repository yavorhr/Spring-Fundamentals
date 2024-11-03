package com.example.gira.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

  @GetMapping("/tasks/add")
  public String addTaskPage(){

    return "add-task";
  }
}
