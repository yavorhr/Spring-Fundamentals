package com.example.musicdb.service.impl;

import com.example.musicdb.model.dto.service.AddAlbumServiceModel;
import com.example.musicdb.model.dto.view.AlbumViewModel;
import com.example.musicdb.model.entity.Album;
import com.example.musicdb.model.entity.Artist;
import com.example.musicdb.model.entity.ArtistsNameEnum;
import com.example.musicdb.model.entity.User;
import com.example.musicdb.repository.AlbumRepository;
import com.example.musicdb.service.AlbumService;
import com.example.musicdb.service.ArtistService;
import com.example.musicdb.service.UserService;
import com.example.musicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
  private final AlbumRepository albumRepository;
  private final ModelMapper modelMapper;
  private final UserService userService;
  private final CurrentUser currentUser;
  private final ArtistService artistService;

  public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, ArtistService artistService) {
    this.albumRepository = albumRepository;
    this.modelMapper = modelMapper;
    this.userService = userService;
    this.currentUser = currentUser;
    this.artistService = artistService;
  }

  @Override
  public boolean validateIfAlbumExists(String name, ArtistsNameEnum artist) {
    return this.albumRepository.findByNameAndArtist_Name(name, artist).isPresent();
  }

  @Override
  public void addAlbum(AddAlbumServiceModel serviceModel) {
    Album album = this.modelMapper.map(serviceModel, Album.class);

    User user = this.userService.findByUsername(currentUser.getUsername()).get();
    album.setUser(user);

    Artist artist = this.artistService.findArtist(serviceModel.getArtist());
    album.setArtist(artist);

    this.albumRepository.save(album);
  }

  @Override
  public Collection<AlbumViewModel> findAllAlbums() {
    return this.albumRepository.findAll().stream()
            .map(a -> {
              AlbumViewModel viewModel = this.modelMapper.map(a, AlbumViewModel.class);
              viewModel.setArtist(a.getArtist().getName());
              return viewModel;
            })
            .collect(Collectors.toList());
  }

  @Override
  public void deleteAlbum(Long id) {
    this.albumRepository.deleteById(id);
  }

  @Override
  public Integer getTotalCopies() {
    return this.albumRepository.findAll().stream().mapToInt(Album::getCopies).sum();
  }
}
