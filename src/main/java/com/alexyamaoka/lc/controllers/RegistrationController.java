package com.alexyamaoka.lc.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		
		// load the saved user data from the database- to show print method is being called for formatter
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("2229995555");
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		userRegistrationDTO.setCommunicationDTO(communicationDTO);

		return "user-registration-page";
	}
	
	
	@RequestMapping("/registration-success")
	public String processUserRegistration(@Valid @ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult) {
		// spring will capture data from url and bind it to userRegistrationDTO automatically
		
		System.out.println("inside process user registration method");
		System.out.println("Name value entered by the user is: " + "|" + userRegistrationDTO.getName() + "|");
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("Age field has errors");
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError error: allErrors) {
				System.out.println(error);
			}
			
			return "user-registration-page";
		}
		
		// save the dto object in the database 
		
		
		return "registration-success";
	}
	

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		System.out.println("inside the init binder method");
		// flow of execution
		// 1) init binder
		// 2) handler method 
		
		// ex: don't want to bind specific data fields such as name
		// webDataBinder.setDisallowedFields("name");
		
		// ex: Property Editor
		// to trim white spaces if user enters a bunch of spaces
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, "name", stringTrimmerEditor);
		
	}
}










