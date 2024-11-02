package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ClassificationEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {
  private ClassificationEnum classification;

  public Classification() {
  }

  public ClassificationEnum getClassification() {
    return classification;
  }

  public Classification setClassification(ClassificationEnum classification) {
    this.classification = classification;
    return this;
  }
}
