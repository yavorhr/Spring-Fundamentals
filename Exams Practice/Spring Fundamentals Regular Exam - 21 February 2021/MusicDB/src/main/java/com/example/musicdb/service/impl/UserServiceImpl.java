package com.example.musicdb.service.impl;

import com.example.musicdb.model.dto.service.UserLoginServiceModel;
import com.example.musicdb.model.dto.service.UserRegisterServiceModel;
import com.example.musicdb.model.entity.User;
import com.example.musicdb.repository.UserRepository;
import com.example.musicdb.service.UserService;
import com.example.musicdb.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;
  private final CurrentUser currentUser;

  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.passwordEncoder = passwordEncoder;
    this.currentUser = currentUser;
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
  public void registerAndLoginUser(UserRegisterServiceModel serviceModel) {
    User entity = this.modelMapper.map(serviceModel, User.class);
    entity.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

    entity = this.userRepository.save(entity);
    this.currentUser.login(entity);
  }

  @Override
  public boolean findByUsernameAndPassword(String username, String password) {
    Optional<User> user = this.userRepository.findByUsername(username);

    if (user.isEmpty()) {
      return false;
    }
    return this.passwordEncoder.matches(password, user.get().getPassword() );
  }

  @Override
  public void loginUser(UserLoginServiceModel serviceModel) {
    User userEntity =
            this.userRepository
                    .findByUsername(serviceModel.getUsername()).get();

    this.currentUser.login(userEntity);
  }

  @Override
  public void logout() {
   this.currentUser.clear();
  }
}
