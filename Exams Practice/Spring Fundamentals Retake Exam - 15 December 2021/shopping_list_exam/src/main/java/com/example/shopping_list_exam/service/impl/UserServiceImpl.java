package com.example.shopping_list_exam.service.impl;

import com.example.shopping_list_exam.model.entity.UserEntity;
import com.example.shopping_list_exam.model.service.UserRegisterServiceModel;
import com.example.shopping_list_exam.repository.UserRepository;
import com.example.shopping_list_exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean isUserNameAvailable(String username) {
    return this.userRepository.findByUsername(username).isEmpty();
  }

  @Override
  public boolean isEmailAvailable(String email) {
    return false;
  }

  @Override
  public void registerUser(UserRegisterServiceModel serviceModel) {
    this.userRepository.save(this.modelMapper.map(serviceModel, UserEntity.class));
  }
}
