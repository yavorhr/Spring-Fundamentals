package com.example.musicdb.service;

import com.example.musicdb.model.entity.Artist;
import com.example.musicdb.model.entity.ArtistsNameEnum;

public interface ArtistService {

  void initArtists();

  Artist findArtist(ArtistsNameEnum artist);
}
