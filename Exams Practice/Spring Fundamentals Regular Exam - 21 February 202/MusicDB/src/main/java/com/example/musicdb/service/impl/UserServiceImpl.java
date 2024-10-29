package com.example.musicdb.service.impl;

import com.example.musicdb.model.dto.service.userRegisterServiceModel;
import com.example.musicdb.model.entity.User;
import com.example.musicdb.repository.UserRepository;
import com.example.musicdb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return this.userRepository.findByEmail(email);
  }

  @Override
  public boolean isUsernameAvailable(String username) {
    return this.findByUsername(username).isEmpty();
  }

  @Override
  public boolean isEmailAvailable(String email) {
    return this.findByEmail(email).isEmpty();
  }

  @Override
  public void registerUser(userRegisterServiceModel serviceModel) {

  }


}
