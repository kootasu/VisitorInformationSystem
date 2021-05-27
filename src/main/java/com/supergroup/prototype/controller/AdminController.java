package com.supergroup.prototype.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supergroup.prototype.model.User;
import com.supergroup.prototype.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, Principal principal) {
		User user = userService.get(principal.getName());
		model.addAttribute("user", user);
		
		return "admin";
	}
}
