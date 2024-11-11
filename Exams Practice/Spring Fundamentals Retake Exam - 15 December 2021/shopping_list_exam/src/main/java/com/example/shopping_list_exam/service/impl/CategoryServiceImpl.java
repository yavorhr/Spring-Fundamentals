package com.example.shopping_list_exam.service.impl;

import com.example.shopping_list_exam.model.entity.Category;
import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import com.example.shopping_list_exam.repository.CategoryRepository;
import com.example.shopping_list_exam.service.CategoryService;
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

                this.categoryRepository.save(category);
              });
    }
  }

}
