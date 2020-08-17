package com.application.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnwerController {

    @RequestMapping({"owner","owner/index"})
    public String getIndex(){
        return "owner/index";
    }
}
