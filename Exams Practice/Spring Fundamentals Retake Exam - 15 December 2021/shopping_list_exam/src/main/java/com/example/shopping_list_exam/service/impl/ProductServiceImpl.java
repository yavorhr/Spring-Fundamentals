package com.example.shopping_list_exam.service.impl;

import com.example.shopping_list_exam.model.entity.Product;
import com.example.shopping_list_exam.model.service.AddProductServiceModel;
import com.example.shopping_list_exam.repository.ProductRepository;
import com.example.shopping_list_exam.service.CategoryService;
import com.example.shopping_list_exam.service.ProductService;
import com.example.shopping_list_exam.service.UserService;
import com.example.shopping_list_exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;
  private final ModelMapper modelMapper;
  private final CategoryService categoryService;
  private final UserService userService;
  private final CurrentUser currentUser;

  public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService, CurrentUser currentUser) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
    this.categoryService = categoryService;
    this.userService = userService;
    this.currentUser = currentUser;
  }

  @Override
  public boolean doesProductExists(String name) {
    return this.productRepository.findByName(name).isEmpty();
  }

  @Override
  public void addProduct(AddProductServiceModel serviceModel) {
    var product = this.modelMapper.map(serviceModel, Product.class);
    product.setCategory(this.categoryService.findCategoryByEnum(serviceModel.getCategory()));
    product.setUser(this.userService.findById(this.currentUser.getId()).get());

    this.productRepository.save(product);
  }

}
