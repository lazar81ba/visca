package main.controller;

import main.service.ViscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZoomController {

    @Autowired
    public ViscaService viscaService;

    public ZoomController(ViscaService viscaService) {
        this.viscaService = viscaService;
    }

    @GetMapping("/zoomTele")
    public String zoomTele() {
        viscaService.zoomTele();
        return "main";
    }

    @GetMapping("/zoomWide")
    public String zoomWide() {
        viscaService.zoomWide();
        return "main";
    }
}
