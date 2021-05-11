package com.supergroup.prototype.controller;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/visitors")
    public String visitors(Model model){
        model.addAttribute("visitors", visitorService.findAll());
        return "visitors";
    }
}
