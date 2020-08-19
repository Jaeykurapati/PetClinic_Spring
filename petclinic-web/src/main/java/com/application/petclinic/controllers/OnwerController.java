package com.application.petclinic.controllers;

import com.application.petclinic.bootstrap.DataLoader;
import com.application.petclinic.services.OwnerService;
import com.application.petclinic.services.map.OwnerMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnwerController {

    private final OwnerService ownerService;

    public OnwerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"owner","owner/index"})
    public String getIndex(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owner/index";
    }
}
