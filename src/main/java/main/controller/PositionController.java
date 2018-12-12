package main.controller;

import main.service.ViscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PositionController {

    @Autowired
    ViscaService viscaService;

    public PositionController(ViscaService viscaService){
        this.viscaService = viscaService;
    }

    @GetMapping("/up")
    public String up() {
        viscaService.up();
        return "main";
    }

    @GetMapping("/down")
    public String down() {
        viscaService.down();
        return "main";
    }

    @GetMapping("/left")
    public String left() {
        viscaService.left();
        return "main";
    }

    @GetMapping("/right")
    public String right() {
        viscaService.right();
        return "main";
    }

    @GetMapping("/home")
    public String home() {
        viscaService.home();
        return "main";
    }

    @GetMapping("/absolute")
    public String absolute() {
        viscaService.absolute();
        return "main";
    }
}
