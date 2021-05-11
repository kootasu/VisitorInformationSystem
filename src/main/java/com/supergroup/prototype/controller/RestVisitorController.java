package com.supergroup.prototype.controller;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestVisitorController {

    @Autowired
    VisitorService visitorService;

    /*@GetMapping("/visitors")
    public String visitors(Model model){
        model.addAttribute("visitors", visitorService.findAll());
        return "visitors";
    }*/

    /*// HTTP Get List
    @GetMapping("/visitors")
    public ResponseEntity<Iterable<Visitor>> findAll(){
        //findAll visitors and return
        return ResponseEntity.status(HttpStatus.OK).body(visitorService.findAll());
    }*/
}