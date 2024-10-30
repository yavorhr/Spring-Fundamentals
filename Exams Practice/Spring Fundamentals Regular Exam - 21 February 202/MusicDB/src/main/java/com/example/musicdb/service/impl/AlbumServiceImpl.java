package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.ArtistsNameEnum;
import com.example.musicdb.repository.AlbumRepository;
import com.example.musicdb.service.AlbumService;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {
  private final AlbumRepository albumRepository;

  public AlbumServiceImpl(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  @Override
  public boolean validateIfAlbumExists(String name, ArtistsNameEnum artist) {
    return this.albumRepository.findByNameAndArtist_Name(name,artist).isPresent();
  }
}
