package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.EmailDTO;

@Controller
public class EmailController {
	
	@RequestMapping("/sendEmail/{username}")			// {} is dynamic. it can be anything 
	public String sendEmail(@PathVariable("username") String username, Model model) {
		
		
		model.addAttribute("emailDTO", new EmailDTO());
		model.addAttribute("username", username.toUpperCase());
		
		return "send-email-page";
	}
	
	
	@RequestMapping("/process-email")
	public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		return "process-email-page";
	}
	
}
