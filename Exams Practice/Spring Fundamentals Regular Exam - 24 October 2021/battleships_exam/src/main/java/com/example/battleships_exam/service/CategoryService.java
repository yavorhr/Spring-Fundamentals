package com.example.battleships_exam.service;

import com.example.battleships_exam.model.entity.Category;
import com.example.battleships_exam.model.entity.enums.CategoryEnum;

public interface CategoryService {
  void initCategories();

  Category findCategory(CategoryEnum category);
}
