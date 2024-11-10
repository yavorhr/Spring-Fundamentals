package com.example.musicdb.model.dto.binding;


import com.example.musicdb.model.entity.ArtistsNameEnum;
import com.example.musicdb.model.entity.GenreEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddAlbumBindingModel {
  private String name;
  private String imageUrl;
  private BigDecimal price;
  private Integer copies;
  private LocalDate releaseDate;
  private String producer;
  private ArtistsNameEnum artist;
  private GenreEnum genre;
  private String description;

  public AddAlbumBindingModel() {
  }

  @NotNull
  @Size(min = 3,max = 20)
  public String getName() {
    return name;
  }

  @NotNull
  @Size(min = 5)
  public String getImageUrl() {
    return imageUrl;
  }

  @NotNull
  @Positive
  public BigDecimal getPrice() {
    return price;
  }

  @NotNull
  @Positive
  public Integer getCopies() {
    return copies;
  }

  @PastOrPresent
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  @NotNull
  @NotEmpty
  public String getProducer() {
    return producer;
  }

  @NotNull
  public ArtistsNameEnum getArtist() {
    return artist;
  }

  @NotNull
  public GenreEnum getGenre() {
    return genre;
  }

  @NotNull
  @NotBlank
  public String getDescription() {
    return description;
  }

  public AddAlbumBindingModel setName(String name) {
    this.name = name;
    return this;
  }

  public AddAlbumBindingModel setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public AddAlbumBindingModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public AddAlbumBindingModel setCopies(Integer copies) {
    this.copies = copies;
    return this;
  }

  public AddAlbumBindingModel setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public AddAlbumBindingModel setProducer(String producer) {
    this.producer = producer;
    return this;
  }

  public AddAlbumBindingModel setArtist(ArtistsNameEnum artist) {
    this.artist = artist;
    return this;
  }

  public AddAlbumBindingModel setGenre(GenreEnum genre) {
    this.genre = genre;
    return this;
  }

  public AddAlbumBindingModel setDescription(String description) {
    this.description = description;
    return this;
  }
}
