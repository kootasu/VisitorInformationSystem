package com.supergroup.prototype.controller;

import com.supergroup.prototype.model.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    User user = new User();

    @RequestMapping("/login")
    public String login(Model model, WebRequest webRequest, @RequestParam String username, @RequestParam String password) {
        String userDatabase = webRequest.getParameter("username");
        String passDatabase = webRequest.getParameter("password");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        if(userDatabase == model.getAttribute("username")){
            System.out.println("Så virker det");
        } else{
            System.out.println("Det virker ikke");
        }
        return "index";
    }

}