package com.example.battleships_exam.service.impl;

import com.example.battleships_exam.model.dto.service.AddShipServiceModel;
import com.example.battleships_exam.model.dto.view.ShipIdAndNameViewModel;
import com.example.battleships_exam.model.dto.view.ShipViewModel;
import com.example.battleships_exam.model.entity.Ship;
import com.example.battleships_exam.repository.ShipRepository;
import com.example.battleships_exam.service.CategoryService;
import com.example.battleships_exam.service.ShipService;
import com.example.battleships_exam.service.UserService;
import com.example.battleships_exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
  private final ShipRepository shipRepository;
  private final CurrentUser currentUser;
  private final ModelMapper modelMapper;
  private final CategoryService categoryService;
  private final UserService userService;

  public ShipServiceImpl(ShipRepository shipRepository, CurrentUser currentUser, ModelMapper modelMapper, CategoryService categoryService, UserService userService) {
    this.shipRepository = shipRepository;
    this.currentUser = currentUser;
    this.modelMapper = modelMapper;
    this.categoryService = categoryService;
    this.userService = userService;
  }

  @Override
  public boolean doesShipExists(String name) {
    return this.shipRepository.findByName(name).isEmpty();
  }

  @Override
  public void addShip(AddShipServiceModel serviceModel) {
    Ship ship = this.modelMapper.map(serviceModel, Ship.class);
    ship.setCategory(this.categoryService.findCategory(serviceModel.getCategory()));
    ship.setUser(this.userService.findUserById(currentUser.getId()).get());

    this.shipRepository.save(ship);
  }

  @Override
  public List<ShipIdAndNameViewModel> findShipsByUserId(Long id) {
    return this.shipRepository.findAllByUserId(id)
            .stream()
            .map(s -> this.mapToViewModel(s, ShipIdAndNameViewModel.class))
            .collect(Collectors.toList());
  }

  @Override
  public List<ShipIdAndNameViewModel> findOtherShips(Long id) {
    return this.shipRepository.findOtherShips(id)
            .stream()
            .map(s -> this.mapToViewModel(s, ShipIdAndNameViewModel.class))
            .collect(Collectors.toList());
  }

  @Override
  public List<ShipViewModel> findAllShips() {
    return this.shipRepository.findAll()
            .stream()
            .map(s -> this.mapToViewModel(s, ShipViewModel.class))
            .collect(Collectors.toList());
  }

  // Helpers
  private <D, T> D mapToViewModel(T source, Class<D> destinationType) {
    return this.modelMapper.map(source, destinationType);
  }
}
