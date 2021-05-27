package com.supergroup.prototype.controller;

import com.supergroup.prototype.model.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supergroup.prototype.model.User;
import com.supergroup.prototype.service.UserService;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    
    @RequestMapping("/")
    public String viewHomePage(Model model, Principal principal) {
        User user = userService.get(principal.getName());
        model.addAttribute("user", user);

        return "index";
    }
    
    @GetMapping("/login")
    public String loginpage() {
    	return "login";
    }

}
