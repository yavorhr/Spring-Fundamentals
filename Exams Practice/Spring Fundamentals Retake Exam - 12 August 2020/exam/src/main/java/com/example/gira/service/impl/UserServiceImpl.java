package com.example.gira.service.impl;

import com.example.gira.model.dto.service.UserLoginServiceModel;
import com.example.gira.model.dto.service.UserRegisterServiceModel;
import com.example.gira.model.entity.UserEntity;
import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
  private final CurrentUser currentUser;

  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.currentUser = currentUser;
  }

  @Override
  public boolean isUserNameAvailable(String username) {
    return this.userRepository.findByUsername(username).isEmpty();
  }

  @Override
  public boolean isEmailAvailable(String email) {
    return this.userRepository.findByEmail(email).isEmpty();
  }

  @Override
  public void registerUser(UserRegisterServiceModel serviceModel) {
    this.userRepository.save(this.modelMapper.map(serviceModel, UserEntity.class));
  }

  @Override
  public boolean doesUserExist(UserLoginServiceModel serviceModel) {
    return this.userRepository.findByEmailAndPassword(serviceModel.getEmail(), serviceModel.getPassword()).isPresent();
  }

  @Override
  public void loginUser(UserLoginServiceModel serviceModel) {
    UserEntity userEntity =
            this.userRepository.findByEmailAndPassword(
                    serviceModel.getEmail(),
                    serviceModel.getPassword())
                    .get();

    this.currentUser.saveSession(userEntity);
  }
}
