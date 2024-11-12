package com.example.shopping_list_exam.service.impl;

import com.example.shopping_list_exam.model.entity.Product;
import com.example.shopping_list_exam.model.service.AddProductServiceModel;
import com.example.shopping_list_exam.model.view.ProductViewModel;
import com.example.shopping_list_exam.repository.ProductRepository;
import com.example.shopping_list_exam.service.CategoryService;
import com.example.shopping_list_exam.service.ProductService;
import com.example.shopping_list_exam.service.UserService;
import com.example.shopping_list_exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

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

  @Override
  public Collection<ProductViewModel> findAllProductsByUser(Long id) {
    return this.productRepository.findAllByUserId(id)
            .stream()
            .map(p -> {
              ProductViewModel viewModel = this.modelMapper.map(p, ProductViewModel.class);
              viewModel.setCategory(p.getCategory().getName());

              return viewModel;
            })
            .collect(Collectors.toList());
  }

  @Override
  public Integer getTotalPriceOfProducts() {
    return this.productRepository
            .findAll()
            .stream()
            .mapToInt(p -> p.getPrice().intValue())
            .sum();
  }

}
