package com.alexyamaoka.lc.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.EmailDTO;

@Controller
public class EmailController {
	
	@RequestMapping("/sendEmail")			
	public String sendEmail(@CookieValue("lcApp.username") String username, Model model) {	
		
		// {} is dynamic. inside it can be anything 
		// @PathVariable("username") String username
		
		// can also use hash map 
		// @PathVariable Map<String, String> pathVarMap
		
		// String username = pathVarMap.get("username");
		// String hobby = pathVarMap.get("hobby");
		
		model.addAttribute("emailDTO", new EmailDTO());
		//model.addAttribute("username", username.toUpperCase());
		
		// add cookie spring way 
		model.addAttribute("username", username);
		
		return "send-email-page";
	}
	
	
	@RequestMapping("/process-email")
	public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		
		
		return "process-email-page";
	}
	
}






// disadvantage of sending data through URL?
// not secure
// too much work to attach info to URL and retrieve it

// How to send/acess data inside multiple controllers/view?
// Session and cookies - store inside server memory




