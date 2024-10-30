package com.example.musicdb.service;

import com.example.musicdb.model.dto.service.AddAlbumServiceModel;
import com.example.musicdb.model.entity.ArtistsNameEnum;

public interface AlbumService {
  boolean validateIfAlbumExists(String name, ArtistsNameEnum artist);

  void addAlbum(AddAlbumServiceModel map);
}
