package com.example.shopping_list_exam.service;

import com.example.shopping_list_exam.model.entity.Category;
import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;

public interface CategoryService {
  void initCategories();

  Category findCategoryByEnum(CategoryEnum category);
}
