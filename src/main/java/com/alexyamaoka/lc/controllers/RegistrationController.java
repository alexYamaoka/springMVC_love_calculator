package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.UserRegistrationDTO;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO) {
		userRegistrationDTO.setName("name demo");
		userRegistrationDTO.setUsername("username demo");
		return "user-registration-page";
	}

}
