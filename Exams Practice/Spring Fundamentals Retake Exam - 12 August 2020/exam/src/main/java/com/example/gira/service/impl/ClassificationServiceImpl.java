package com.example.gira.service.impl;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationEnum;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class ClassificationServiceImpl implements ClassificationService {
  private final ClassificationRepository classificationRepository;

  public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
    this.classificationRepository = classificationRepository;
  }

  @Override
  public void initObjects() {
    Arrays.stream(ClassificationEnum.values())
            .forEach(e -> {
              Classification obj = new Classification();
              obj.setClassification(e);
              this.classificationRepository.save(obj);
            });
  }

  @Override
  public Optional<Classification> findByName(ClassificationEnum classificationEnum) {
    return this.classificationRepository.findByClassification(classificationEnum);
  }
}
