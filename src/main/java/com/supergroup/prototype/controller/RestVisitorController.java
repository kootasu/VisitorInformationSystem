package com.supergroup.prototype.controller;

import com.supergroup.prototype.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestVisitorController {

    @Autowired
    VisitorService visitorService;

    @GetMapping("/visitors")
    public String mods(Model model){
        model.addAttribute("visitors", visitorService.findAll());
        return "visitors";
    }

}
