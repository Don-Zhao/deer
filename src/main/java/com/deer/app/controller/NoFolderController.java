package com.deer.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoFolderController {
	
	@RequestMapping("/home")
	public String test(Model model) {
		User user = this.getUser();
		model.addAttribute("username", user.getUsername());
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
	
	public User getUser() {
		User user = null;
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) {
			user = (User)auth.getPrincipal();
		}
		
		return user;
	}
}
