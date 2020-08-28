package com.application.petclinic.controllers;

import com.application.petclinic.bootstrap.DataLoader;
import com.application.petclinic.services.OwnerService;
import com.application.petclinic.services.map.OwnerMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndex(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping("/find")
    public String findOwner(){
        return "notImplemented";
    }
}
