package com.supergroup.prototype.controller;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/visitors")
    public String visitors(Model model) {
        model.addAttribute("visitors", visitorService.findAll());
        return "visitors";
    }

    @GetMapping("/createVisitor")
    public String create() {
        return "createVisitor";
    }

    @GetMapping("/createVisitorWithIcons")
    public String createWithIcons() {
        return "createVisitorWithIcons";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String create(@ModelAttribute Visitor visitor) {
        Visitor newVisitor = visitorService.create(visitor);
        visitorService.update(newVisitor);
        return "redirect:/";
    }

    @GetMapping("/createGroupOfVisitors")
    public String createGroupOfVisitors(){
        return "createGroupOfVisitors";
    }

    @RequestMapping(value = "/createGroup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String createGroup(@ModelAttribute Visitor visitor, WebRequest request) {
        int groupQuantity = Integer.parseInt(request.getParameter("gruppeAntal"));
        visitorService.createGroupVisitor(visitor, groupQuantity);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("visitor", visitorService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Visitor visitor) {
        visitorService.update(visitor);
        return "redirect:/visitors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        visitorService.deleteById(id);
        return "redirect:/visitors";
    }
}