package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.Artist;
import com.example.musicdb.model.entity.ArtistsNameEnum;
import com.example.musicdb.repository.ArtistRepository;
import com.example.musicdb.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
  private final ArtistRepository artistRepository;

  public ArtistServiceImpl(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  @Override
  public void initArtists() {
    if (this.artistRepository.count() == 0) {
      Artist queen = createArtist(ArtistsNameEnum.Queen, "•\tMetallica is an American heavy metal band. The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San Francisco for most of its career. The band's fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett, and bassist Robert Trujillo. Guitarist Dave Mustaine and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.");
      Artist madonna = createArtist(ArtistsNameEnum.Madonna, "•\tMadonna Louise Ciccone - born and raised in Michigan, Madonna moved to New York City in 1978 to pursue a career in modern dance. After performing as a drummer, guitarist, and vocalist in the rock bands Breakfast Club and Emmy, she rose to solo stardom with her debut studio album, Madonna (1983). She followed it with a series of successful albums, including all-time bestsellers Like a Virgin (1984) and True Blue (1986) as well as Grammy Award winners Ray of Light (1998) and Confessions on a Dance Floor (2005).");
      Artist metallica = createArtist(ArtistsNameEnum.Metallica, "•\tMetallica is an American heavy metal band. The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San Francisco for most of its career. The band's fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett, and bassist Robert Trujillo. Guitarist Dave Mustaine and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.");

      this.artistRepository.saveAll(List.of(queen, metallica,madonna));
    }
  }

  @Override
  public Artist findArtist(ArtistsNameEnum artist) {
    return this.artistRepository.findByName(artist).get();
  }

  // Helpers

  private Artist createArtist(ArtistsNameEnum name, String description) {
    return new Artist(name, description);
  }
}


