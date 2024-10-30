package com.example.musicdb.repository;

import com.example.musicdb.model.entity.Album;
import com.example.musicdb.model.entity.Artist;
import com.example.musicdb.model.entity.ArtistsNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

  Optional<Album> findByNameAndArtist_Name(String name, ArtistsNameEnum artisName);
}
