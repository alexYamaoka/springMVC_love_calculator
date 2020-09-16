package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LCAppController {
	
	@RequestMapping("/")
	public String showHomePage() {
		
		return "home-page";
	}
	
	
	@RequestMapping("/process-homepage")
	public String showResultPage(Model model, @RequestParam String username, @RequestParam String crushName) {
		// @RequestParam - used for data binding form parameter to variables
		// to change variable name: @RequestParam("username") String UN 
		
		System.out.println("username: " + username);
		System.out.println("crush name: " + crushName);
		
		model.addAttribute("username", username);
		model.addAttribute("crushName", crushName);
		
		return "result-page";
	}
}
