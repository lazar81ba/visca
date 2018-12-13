package main.controller;

import main.service.ViscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PositionController {

    @Autowired
    ViscaService viscaService;

    public PositionController(ViscaService viscaService){
        this.viscaService = viscaService;
    }

    @GetMapping("/up")
    public String up(Model model) {
        model.addAttribute("text",viscaService.up());
        return "main";
    }

    @GetMapping("/down")
    public String down(Model model) {
        model.addAttribute("text",viscaService.down());
        return "main";
    }

    @GetMapping("/left")
    public String left(Model model) {
        model.addAttribute("text",viscaService.left());
        return "main";
    }

    @GetMapping("/right")
    public String right(Model model) {
        model.addAttribute("text",viscaService.right());
        return "main";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("text",viscaService.home());
        return "main";
    }

    @GetMapping("/absolute")
    public String absolute(Model model) {
        model.addAttribute("text",viscaService.absolute());
        return "main";
    }
}
