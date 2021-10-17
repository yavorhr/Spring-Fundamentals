package softuni.pathfinder.Web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.pathfinder.Entities.BindingDtos.UserRegisterBindingDto;
import softuni.pathfinder.Entities.ServiceDtos.UserRegisterServiceDto;
import softuni.pathfinder.Services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

//    @ModelAttribute
//    public UserRegisterBindingDto userRegisterBindingDto(){
//        return new UserRegisterBindingDto();
//    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        if (!model.containsAttribute("userRegisterBindingDto")) {
            model.addAttribute("userRegisterBindingDto", new UserRegisterBindingDto());
            model.addAttribute("usernameAlreadyExists", false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingDto userRegisterBindingDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingDto.getPassword().equals(userRegisterBindingDto.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingDto", userRegisterBindingDto)
                    .addFlashAttribute("org.springframework.validation.userRegisterBindingDto", bindingResult);

            return "redirect:register/";
        }

        boolean doesUsernameExist = userService.doesUsernameAlreadyExist(userRegisterBindingDto.getUsername());

        if (doesUsernameExist) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingDto", userRegisterBindingDto)
                    .addFlashAttribute("org.springframework.validation.userRegisterBindingDto", bindingResult)
                    .addFlashAttribute("usernameAlreadyExists", "true");

            return "redirect:register/";
        }

        userService
                .registerUser(modelMapper
                        .map(userRegisterBindingDto, UserRegisterServiceDto.class));

        return "redirect:login";
    }
}
