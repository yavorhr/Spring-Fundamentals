package softuni.pathfinder.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    @GetMapping("/all")
    public String getAllRoutes(){
    //TODO
        return "routes";
    }
}
