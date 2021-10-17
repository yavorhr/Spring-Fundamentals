package softuni.pathfinder.Web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.pathfinder.Services.PictureService;

@Controller
public class HomeController {

    private final PictureService pictureService;
    private final ModelMapper modelMapper;

    public HomeController(PictureService pictureService, ModelMapper modelMapper) {
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/")
    public String visualizeGallery(Model model){
        model.addAttribute("pictures", pictureService.findAllPictures());

        return "index";
    }

}
