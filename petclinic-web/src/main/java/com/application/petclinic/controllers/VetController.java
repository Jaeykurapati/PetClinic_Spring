package com.application.petclinic.controllers;

import com.application.petclinic.services.map.VetMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vets")
@Controller
public class VetController {

    private final VetMapService vetMapService;

    public VetController(VetMapService vetMapService) {
        this.vetMapService = vetMapService;
    }

    @RequestMapping({"/index","/index.html"})
    public String getIndex(Model model){
        model.addAttribute("vets",vetMapService.findAll());
        return "vet/index";
    }
}