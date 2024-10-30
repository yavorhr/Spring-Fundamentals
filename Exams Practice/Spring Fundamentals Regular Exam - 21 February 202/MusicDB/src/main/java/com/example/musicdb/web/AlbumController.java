package com.example.musicdb.web;

import com.example.musicdb.model.dto.binding.AddAlbumBindingModel;
import com.example.musicdb.model.dto.service.AddAlbumServiceModel;
import com.example.musicdb.service.AlbumService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlbumController {
  private final ModelMapper mapper;
  private final AlbumService albumService;

  public AlbumController(ModelMapper mapper, AlbumService albumService) {
    this.mapper = mapper;
    this.albumService = albumService;
  }

  @ModelAttribute("addAlbumBindingModel")
  public AddAlbumBindingModel addAlbumBindingModel(){
    return new AddAlbumBindingModel();
  }

  @GetMapping("/albums/add")
  public String getAddAlbumPage(Model model) {
    if (model.containsAttribute("albumExists")) {
      model.addAttribute("albumExists", false);
    }

    return "add-album";
  }

  @PostMapping("/albums/add")
  public String addAlbum(@Valid AddAlbumBindingModel addAlbumBindingModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

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
}
