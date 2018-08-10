package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kamil on 25.07.2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String home() {
        return "forward:home.html";
    }
}
