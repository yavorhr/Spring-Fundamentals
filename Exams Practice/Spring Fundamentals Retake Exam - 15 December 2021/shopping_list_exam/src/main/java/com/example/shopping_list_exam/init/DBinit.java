package com.example.shopping_list_exam.init;

import com.example.shopping_list_exam.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinit implements CommandLineRunner {
  private final CategoryService categoryService;

  public DBinit(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.categoryService.initCategories();
  }
}
