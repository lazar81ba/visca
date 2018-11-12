package main.controller;

import main.request.ChangeSecondsRequest;
import main.service.ViscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(value = "/setSeconds")
    public String setSeconds(@RequestParam Integer seconds) {
        viscaService.setSleep(seconds);
        return "redirect:/main";
    }

}