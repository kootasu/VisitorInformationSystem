package com.supergroup.prototype.controller;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/visitors", method = RequestMethod.GET)
    public String visitors(Model model) {
        model.addAttribute("visitors", visitorService.findAll());
        return "visitors";
    }

    @RequestMapping(value = "/createVisitor", method = RequestMethod.GET)
    public String createWithIcons() {
        return "createVisitor";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Visitor visitor) {
        Visitor newVisitor = visitorService.create(visitor);
        visitorService.update(newVisitor);
        return "redirect:/";
    }

    @RequestMapping(value = "/createGroupOfVisitors", method = RequestMethod.GET)
    public String createGroupOfVisitors(){
        return "createGroupOfVisitors";
    }

    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
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