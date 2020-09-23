package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.EmailDTO;

@Controller
public class EmailController {
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		return "send-email-page";
	}
	
	
	@RequestMapping("/process-email")
	public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		return "process-email-page";
	}
	
}
