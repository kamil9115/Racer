package pl.edu.wat.wcy.tim.Racer.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value="/")
    public String home(){
        return "forward:index.html";
    }
}
