package softuni.pathfinder.Web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.pathfinder.Entities.BindingDtos.UserLoginBindingDto;
import softuni.pathfinder.Entities.ServiceDtos.UserLoginServiceDto;
import softuni.pathfinder.Services.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserLoginAndLogoutController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserLoginAndLogoutController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    //    @ModelAttribute
    //    public UserRegisterBindingDto userRegisterBindingDto(){
    //        return new UserRegisterBindingDto();
    //    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        if (!model.containsAttribute("userLoginBindingDto")) {
            model.addAttribute("userLoginBindingDto", new UserLoginBindingDto());
            model.addAttribute("userNotExists", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid UserLoginBindingDto userLoginBindingDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        UserLoginServiceDto user = userService.
                findUserByUserNameAndPassword
                        (userLoginBindingDto.getUsername(), userLoginBindingDto.getPassword());

        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingDto", userLoginBindingDto)
                    .addFlashAttribute("org.springframework.validation.userLoginBindingDto", bindingResult)
                    .addFlashAttribute("userNotExists", true);
            return "redirect:login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingDto", userLoginBindingDto)
                    .addFlashAttribute("org.springframework.validation.userLoginBindingDto", bindingResult);
            return "redirect:login";
        }

       userService.loginUser(user.getId(),user.getUsername());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }


}
