package com.example.shopping_list_exam.service;

import com.example.shopping_list_exam.model.service.AddProductServiceModel;

public interface ProductService {
  boolean doesProductExists(String name);

  void addProduct(AddProductServiceModel serviceModel);
}
