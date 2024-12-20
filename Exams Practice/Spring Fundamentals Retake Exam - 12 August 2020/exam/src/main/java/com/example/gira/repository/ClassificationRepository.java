package com.example.gira.repository;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

  Optional<Classification> findByClassification(ClassificationEnum classification);
}
