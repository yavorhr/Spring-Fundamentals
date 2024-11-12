package com.example.shopping_list_exam.service;

import com.example.shopping_list_exam.model.service.AddProductServiceModel;
import com.example.shopping_list_exam.model.view.ProductViewModel;

import java.util.Collection;

public interface ProductService {
  boolean doesProductExists(String name);

  void addProduct(AddProductServiceModel serviceModel);

  Collection<ProductViewModel> findAllProductsByUser(Long id);

  Integer getTotalPriceOfProducts();

  void removeProduct(Long id);
}
