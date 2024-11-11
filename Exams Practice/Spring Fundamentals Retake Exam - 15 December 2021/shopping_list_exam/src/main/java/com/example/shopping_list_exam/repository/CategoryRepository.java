package com.example.shopping_list_exam.repository;

import com.example.shopping_list_exam.model.entity.Category;
import com.example.shopping_list_exam.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

  Optional<Category> findByName(CategoryEnum name);
}
