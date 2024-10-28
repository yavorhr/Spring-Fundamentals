package com.example.musicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

  @GetMapping("/albums/add")
  public String getAddAlbumPage(){
    return "add-album";
  }
}
