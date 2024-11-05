package com.example.battleships_exam.service.impl;

import com.example.battleships_exam.model.entity.Category;
import com.example.battleships_exam.model.entity.enums.CategoryEnum;
import com.example.battleships_exam.repository.CategoryRepository;
import com.example.battleships_exam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void initCategories() {
    if (this.categoryRepository.count() == 0) {
      Arrays.stream(CategoryEnum.values())
              .forEach(c -> {
                Category category = new Category();
                category.setName(c);
                category.setDescription("Some very nice category description here.");

                this.categoryRepository.save(category);
              });
    }
  }
}
