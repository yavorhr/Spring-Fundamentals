package com.example.musicdb.web;

import com.example.musicdb.model.dto.binding.AddAlbumBindingModel;
import com.example.musicdb.model.dto.service.AddAlbumServiceModel;
import com.example.musicdb.service.AlbumService;
import com.example.musicdb.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/albums")
public class AlbumController {
  private final ModelMapper mapper;
  private final AlbumService albumService;
  private final CurrentUser currentUser;

  public AlbumController(ModelMapper mapper, AlbumService albumService, CurrentUser currentUser) {
    this.mapper = mapper;
    this.albumService = albumService;
    this.currentUser = currentUser;
  }

  @ModelAttribute("addAlbumBindingModel")
  public AddAlbumBindingModel addAlbumBindingModel() {
    return new AddAlbumBindingModel();
  }

  @GetMapping("/add")
  public String getAddAlbumPage(Model model) {
    if (!model.containsAttribute("albumExists")) {
      model.addAttribute("albumExists", false);
    }

    return "add-album";
  }

  @PostMapping("/add")
  public String addAlbum(@Valid AddAlbumBindingModel addAlbumBindingModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

    if (!currentUser.isLoggedIn()) {
      return "redirect:/users/login";
    }

    if (bindingResult.hasErrors()) {
      redirectAttributes
              .addFlashAttribute("addAlbumBindingModel", addAlbumBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.addAlbumBindingModel", bindingResult);

      return "redirect:add";
    }

    boolean albumExists =
            this.albumService.validateIfAlbumExists(
                    addAlbumBindingModel.getName(),
                    addAlbumBindingModel.getArtist());

    if (albumExists) {
      redirectAttributes
              .addFlashAttribute("addAlbumBindingModel", addAlbumBindingModel)
              .addFlashAttribute("org.springframework.validation.BindingResult.addAlbumBindingModel", bindingResult)
              .addFlashAttribute("albumExists", true);

      return "redirect:add";
    }

    this.albumService.addAlbum(this.mapper.map(addAlbumBindingModel, AddAlbumServiceModel.class));

    return "redirect:/home";
  }

  @DeleteMapping("/{id}")
  public String deleteAlbum(@PathVariable Long id) {
    this.albumService.deleteAlbum(id);

    return "redirect:/home";
  }
}
