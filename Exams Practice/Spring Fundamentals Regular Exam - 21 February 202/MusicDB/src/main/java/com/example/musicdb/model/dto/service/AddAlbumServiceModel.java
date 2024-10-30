package com.example.musicdb.model.dto.service;

import com.example.musicdb.model.entity.ArtistsNameEnum;
import com.example.musicdb.model.entity.GenreEnum;
import com.example.musicdb.model.entity.User;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddAlbumServiceModel {
  private String name;
  private String imageUrl;
  private BigDecimal price;
  private Integer copies;
  private LocalDate releaseDate;
  private String producer;
  private ArtistsNameEnum artist;
  private GenreEnum genre;
  private User user;
  private String description;

  public AddAlbumServiceModel() {
  }
  
  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Integer getCopies() {
    return copies;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public String getProducer() {
    return producer;
  }

  public ArtistsNameEnum getArtist() {
    return artist;
  }

  public GenreEnum getGenre() {
    return genre;
  }

  public User getUser() {
    return user;
  }

  public String getDescription() {
    return description;
  }

  public AddAlbumServiceModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddAlbumServiceModel setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public AddAlbumServiceModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public AddAlbumServiceModel setCopies(Integer copies) {
    this.copies = copies;
    return this;
  }

  public AddAlbumServiceModel setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public AddAlbumServiceModel setProducer(String producer) {
    this.producer = producer;
    return this;
  }

  public AddAlbumServiceModel setArtist(ArtistsNameEnum artist) {
    this.artist = artist;
    return this;
  }

  public AddAlbumServiceModel setGenre(GenreEnum genre) {
    this.genre = genre;
    return this;
  }

  public AddAlbumServiceModel setUser(User user) {
    this.user = user;
    return this;
  }

  public AddAlbumServiceModel setDescription(String description) {
    this.description = description;
    return this;
  }
}
