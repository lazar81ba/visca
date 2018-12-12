package main.controller;

import main.service.ViscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    ViscaService viscaService;

    public MainController(ViscaService viscaService) {
        this.viscaService = viscaService;
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }


}