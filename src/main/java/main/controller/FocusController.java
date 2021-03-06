package main.controller;

import main.service.ViscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FocusController {

    private ViscaService viscaService;

    @Autowired
    public FocusController(ViscaService viscaService) {
        this.viscaService = viscaService;
    }

    @GetMapping("/far")
    public String far(Model model) {
        model.addAttribute("text",viscaService.focusFar());
        return "main";
    }

    @GetMapping("/near")
    public String near(Model model) {
        model.addAttribute("text",viscaService.focusNear());
        return "main";
    }

}
