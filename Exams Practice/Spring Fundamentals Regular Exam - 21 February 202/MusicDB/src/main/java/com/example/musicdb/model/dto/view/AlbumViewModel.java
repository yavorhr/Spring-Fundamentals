package com.example.musicdb.model.dto.view;

import com.example.musicdb.model.entity.ArtistsNameEnum;
import com.example.musicdb.model.entity.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
  private Long id;
  private String name;
  private ArtistsNameEnum artist;
  private GenreEnum genre;
  private BigDecimal price;
  private LocalDate releaseDate;

  public AlbumViewModel() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public ArtistsNameEnum getArtist() {
    return artist;
  }

  public GenreEnum getGenre() {
    return genre;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public AlbumViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public AlbumViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public AlbumViewModel setArtist(ArtistsNameEnum artist) {
    this.artist = artist;
    return this;
  }

  public AlbumViewModel setGenre(GenreEnum genre) {
    this.genre = genre;
    return this;
  }

  public AlbumViewModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public AlbumViewModel setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }
}
