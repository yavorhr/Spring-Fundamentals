package com.example.musicdb.service;

import com.example.musicdb.model.dto.service.AddAlbumServiceModel;
import com.example.musicdb.model.dto.view.AlbumViewModel;
import com.example.musicdb.model.entity.ArtistsNameEnum;

import java.util.Collection;

public interface AlbumService {
  boolean validateIfAlbumExists(String name, ArtistsNameEnum artist);

  void addAlbum(AddAlbumServiceModel map);

  Collection<AlbumViewModel> findAllAlbums();

  void deleteAlbum(Long id);

  Integer getTotalCopies();
}
