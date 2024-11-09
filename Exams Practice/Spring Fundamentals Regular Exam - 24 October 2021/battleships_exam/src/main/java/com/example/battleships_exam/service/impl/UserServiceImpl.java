package com.example.battleships_exam.service.impl;

import com.example.battleships_exam.model.dto.service.UserLoginServiceModel;
import com.example.battleships_exam.model.dto.service.UserRegisterServiceModel;
import com.example.battleships_exam.model.entity.UserEntity;
import com.example.battleships_exam.repository.UserRepository;
import com.example.battleships_exam.service.UserService;
import com.example.battleships_exam.util.CurrentUser;
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
    UserEntity user = this.modelMapper.map(serviceModel, UserEntity.class);
    this.userRepository.save(user);
  }

  @Override
  public boolean doesUserExist(UserLoginServiceModel serviceModel) {
    return this.userRepository.findByUsernameAndPassword(serviceModel.getUsername(),serviceModel.getPassword()).isPresent();
  }

  @Override
  public void loginUser(UserLoginServiceModel serviceModel) {
    UserEntity userEntity =
            this.userRepository.findByUsernameAndPassword(
                    serviceModel.getUsername(),
                    serviceModel.getPassword())
                    .get();

    this.currentUser.saveSession(userEntity);
  }
}
