package com.example.musicdb.init;


import com.example.musicdb.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DBinit implements CommandLineRunner {
  private final ArtistService artistService;

  public DBinit(ArtistService artistService) {
    this.artistService = artistService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.artistService.initArtists();
  }
}
