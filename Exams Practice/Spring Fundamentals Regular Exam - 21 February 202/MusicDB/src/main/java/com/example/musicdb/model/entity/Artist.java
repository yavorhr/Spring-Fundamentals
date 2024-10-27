package com.example.musicdb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Artist extends BaseEntity {
  private String careerInformation;
  private ArtistsNameEnum name;

  public Artist() {
  }

  @Column(columnDefinition = "LONGTEXT")
  public String getCareerInformation() {
    return careerInformation;
  }

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public ArtistsNameEnum getName() {
    return name;
  }

  public Artist setCareerInformation(String careerInformation) {
    this.careerInformation = careerInformation;
    return this;
  }

  public Artist setName(ArtistsNameEnum name) {
    this.name = name;
    return this;
  }
}
