package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLoginPage() {
		
		return "login";
	}
	
	
	@RequestMapping("/process-login")
	public String processLogin() {
		
		return "home-page";
	}
}
