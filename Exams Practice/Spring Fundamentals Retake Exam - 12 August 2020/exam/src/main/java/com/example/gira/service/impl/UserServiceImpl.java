package com.example.gira.service.impl;

import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isUserNameAvailable(String username) {
    return this.userRepository.findByUsername(username).isEmpty();
  }
}
