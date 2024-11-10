package com.example.musicdb.web;

import com.example.musicdb.model.dto.view.AlbumViewModel;
import com.example.musicdb.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class HomeController {
  private final AlbumService albumService;

  public HomeController(AlbumService albumService) {
    this.albumService = albumService;
  }

  @GetMapping("/")
  public String indexPage() {
    return "index";
  }

  @GetMapping("/home")
  public String homePage(Model model) {

    Collection<AlbumViewModel> allAlbums = this.albumService.findAllAlbums();

    model.addAttribute("albumsViewModels",allAlbums );
    model.addAttribute("totalCopies",this.albumService.getTotalCopies() );

    return "home";
  }
}
