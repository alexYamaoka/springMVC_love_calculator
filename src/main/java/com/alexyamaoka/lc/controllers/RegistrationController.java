package com.alexyamaoka.lc.controllers;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.CommunicationDTO;
import com.alexyamaoka.lc.api.CreditCard;
import com.alexyamaoka.lc.api.Phone;
import com.alexyamaoka.lc.api.UserRegistrationDTO;
import com.alexyamaoka.lc.database.RegisteredUsersDAO;
import com.alexyamaoka.lc.propertyEditor.CreditCardEditor;
import com.alexyamaoka.lc.propertyEditor.NamePropertyEditor;
import com.alexyamaoka.lc.validator.EmailValidator;
import com.alexyamaoka.lc.validator.UsernameValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private RegisteredUsersDAO registeredUsersDAO;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO) {
		System.out.println("inside show registration page method");
		
		// load the saved user data from the database- to show print method is being called for formatter
		Phone phone = new Phone();
		phone.setCountryCode("1");
		phone.setUserNumber("2229995555");
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		userRegistrationDTO.setCommunicationDTO(communicationDTO);

		return "user-registration-page";
	}
	
	
	@RequestMapping("/registration-success")
	public String processUserRegistration(@Valid @ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult) throws ClassNotFoundException {
		// spring will capture data from url and bind it to userRegistrationDTO automatically
		
		System.out.println("inside process user registration method");
		System.out.println("Name value entered by the user is: " + "|" + userRegistrationDTO.getName() + "|");
		
		// can call validator manually from controller method 
		// EmailValidator emailValidator = new EmailValidator(); 
		emailValidator.validate(userRegistrationDTO, bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("Age field has errors");
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError error: allErrors) {
				System.out.println(error);
			}
			
			return "user-registration-page";
		}
		
		// save the dto object in the database 
		try {
			
			registeredUsersDAO.saveUser(userRegistrationDTO);
			
		} 
		catch (SQLException e) {
			System.out.println("inside catch block");
			e.printStackTrace();
		}
		
		
		return "registration-success";
	}
	

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		System.out.println("inside the init binder method og Registration Controller");
		// flow of execution
		// 1) init binder
		// 2) handler method 
		
		
		// Property Editor
		// Spring uses property editors to convert strings to object types and object types to Strings
		
		// WebDataBinder
		// binder that is responsible for setting property values on to a target object
		// setting form fields into beans
		// - custom editors
		// - Validators
		// - required properties
		// - allowed/disallowed properties
		
		// initBinder initializes webDataBinder
		
		// ex: don't want to bind specific data fields such as name
		// webDataBinder.setDisallowedFields("name");
		
		
		
		// to trim white spaces if user enters a bunch of spaces.  
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, "name", stringTrimmerEditor);
		
		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		webDataBinder.registerCustomEditor(String.class, "name", namePropertyEditor);
		
		
		
		// add custom validator
		UsernameValidator usernameValidator = new UsernameValidator();
		webDataBinder.addValidators(usernameValidator);
		
		// EmailValidator emailValidator = new EmailValidator();
		// webDataBinder.addValidators(emailValidator);

	}
	
	
	@RequestMapping("/view-all")
	public String viewAllRegisteredUsers(Model model) throws ClassNotFoundException, SQLException {
		
		Map<String, UserRegistrationDTO> usersMap = registeredUsersDAO.viewAllRegisteredUsers();
		model.addAttribute("usersMap", usersMap);
		
		return "view-all-users-page";
	}
	
	
	
	
	
	
	
	
	
	
}










