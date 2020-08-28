package com.application.petclinic.controllers;

import com.application.petclinic.services.map.VetMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    private  VetMapService vetMapService;

    @Autowired
    public void setVetMapService(VetMapService vetMapService) {
        this.vetMapService = vetMapService;
    }

    @RequestMapping({"","/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping({"vets.html"})
    public String getIndex(Model model){
        model.addAttribute("vets",vetMapService.findAll());
        return "vet/index";
    }

    @RequestMapping("oups")
    public String oopsPage(){
        return "notImplemented";
    }

}