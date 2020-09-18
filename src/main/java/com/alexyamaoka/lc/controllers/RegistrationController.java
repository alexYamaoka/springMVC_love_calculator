package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.CommunicationDTO;
import com.alexyamaoka.lc.api.Phone;
import com.alexyamaoka.lc.api.UserRegistrationDTO;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO) {
		System.out.println("inside show registration page method");
		
		// load the saved user data from the database
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("2229995555");
		
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		userRegistrationDTO.setCommunicationDTO(communicationDTO);

		return "user-registration-page";
	}
	
	
	@RequestMapping("/registration-success")
	public String processUserRegistration(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO) {
		// spring will capture data from url and bind it to userRegistrationDTO automatically
		
		System.out.println("inside process user registration method");
		
		// save the dto object in the database 
		
		
		return "registration-success";
	}
}
