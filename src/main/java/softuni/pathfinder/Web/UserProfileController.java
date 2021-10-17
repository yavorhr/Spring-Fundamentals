package softuni.pathfinder.Web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.pathfinder.Entities.ViewDtos.UserProfileViewDto;
import softuni.pathfinder.Services.UserService;

@Controller
@RequestMapping("/users")
public class UserProfileController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserProfileController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable Long id, Model model) {
        model.addAttribute("userViewDto",
                modelMapper.map(userService.findUserById(id), UserProfileViewDto.class));

        return "profile";
    }
}
