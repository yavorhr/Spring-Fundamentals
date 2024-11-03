package com.example.gira.service;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationEnum;

import java.util.Optional;

public interface ClassificationService {
  void initObjects();

  Optional<Classification> findByName(ClassificationEnum classificationEnum);
}
