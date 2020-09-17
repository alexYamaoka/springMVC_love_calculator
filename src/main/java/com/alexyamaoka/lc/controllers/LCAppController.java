package com.alexyamaoka.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexyamaoka.lc.api.UserInfoDTO;

@Controller
public class LCAppController {
	
	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO) {
		// read the existing property by fetching it from the dto 
		
		return "home-page";
	}
	
	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, BindingResult bindingResult) {
		// Spring binds the data automatically from the url 
		// writing the value to the properties by fetching from the url
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError oe: allErrors) {
				System.out.println(oe);
			}
			
			return "home-page";
		}
		
		return "result-page";
	}	
}
	




//	@RequestMapping("/")
//	public String showHomePage(Model model) {
//		// read the existing property by fetching it from the dto 
//		UserInfoDTO userInfoDTO = new UserInfoDTO();
//		model.addAttribute("userInfoDTO", userInfoDTO);	
//		
//		return "home-page";
//	}
//
//	@RequestMapping("/process-homepage")
//	public String showResultPage(Model model, @RequestParam String username, @RequestParam String crushName) {
//		// @RequestParam - used for data binding form parameter to variables
//		// to change variable name: @RequestParam("username") String UN 
//		
//		System.out.println("username: " + username);
//		System.out.println("crush name: " + crushName);
//		
//		model.addAttribute("username", username);
//		model.addAttribute("crushName", crushName);
//		
//		return "result-page";
//	}

