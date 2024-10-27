package com.example.musicdb.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity {
  private Integer copies;
  private String description;
  private GenreEnum genre;
  private String imageUrl;
  private String name;
  private BigDecimal price;
  private String producer;
  private LocalDate releaseDate;
  private User user;
  private Artist artist;

  public Album() {
  }

  @Column(nullable = false)
  public Integer getCopies() {
    return copies;
  }

  @Column(columnDefinition = "TEXT", nullable = false)
  public String getDescription() {
    return description;
  }

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public GenreEnum getGenre() {
    return genre;
  }

  @Column(name = "image_url", nullable = false)
  public String getImageUrl() {
    return imageUrl;
  }

  @Column(nullable = false)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public BigDecimal getPrice() {
    return price;
  }

  @Column(nullable = false)
  public String getProducer() {
    return producer;
  }

  @Column(nullable = false)
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  @ManyToOne
  public User getUser() {
    return user;
  }

  @ManyToOne
  public Artist getArtist() {
    return artist;
  }

  public Album setCopies(Integer copies) {
    this.copies = copies;
    return this;
  }

  public Album setDescription(String description) {
    this.description = description;
    return this;
  }

  public Album setGenre(GenreEnum genre) {
    this.genre = genre;
    return this;
  }

  public Album setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public Album setName(String name) {
    this.name = name;
    return this;
  }

  public Album setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public Album setProducer(String producer) {
    this.producer = producer;
    return this;
  }

  public Album setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public Album setUser(User user) {
    this.user = user;
    return this;
  }

  public Album setArtist(Artist artist) {
    this.artist = artist;
    return this;
  }
}
