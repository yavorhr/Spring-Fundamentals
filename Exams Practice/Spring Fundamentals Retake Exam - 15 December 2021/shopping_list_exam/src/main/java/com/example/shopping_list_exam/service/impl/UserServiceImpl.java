package com.example.shopping_list_exam.service.impl;

import com.example.shopping_list_exam.repository.UserRepository;
import com.example.shopping_list_exam.service.UserService;
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

  @Override
  public boolean isEmailAvailable(String email) {
    return false;
  }
}
