package com.alexyamaoka.lc.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alexyamaoka.lc.api.UserInfoDTO;

@Controller
@SessionAttributes
public class LCAppController {
	
	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO) {   
		// read the existing property by fetching it from the dto 
		
		
//		HttpServletRequest httpServletRequest  // inside method parameter
//		Cookie[] cookiesArray = httpServletRequest.getCookies();
//		
//		for (Cookie cookie: cookiesArray) {
//			if (cookie.getName().equals("lcApp.username")) {
//				String myUsername = cookie.getValue();
//				userInfoDTO.setUsername(myUsername);
//			}
//		}
		
		return "home-page";
	}
	
	
	
	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, BindingResult bindingResult) {
		// Spring binds the data automatically from the url 
		// writing the value to the properties by fetching from the url
		
		System.out.println(userInfoDTO.isAgreedToTermsAndCondition());
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError oe: allErrors) {
				System.out.println(oe);
			}
			
			return "home-page";
		}
		
		
		
		
		
		// if its a new user, create a new session. if returning user, retrieve cookie
		// this attribute is available among all jsp or controller pages
		// by default, the session objects are stored inside the server memory - deleted once the server is stopped
		
		// HttpServletRequest httpServletRequest   // include in method parameter
//		HttpSession httpSession = httpServletRequest.getSession();
//		httpSession.setAttribute("username", userInfoDTO.getUsername());
//		httpSession.setMaxInactiveInterval(120);
		
		
		
		
//		// create a cookie for the username
		// HttpServletResponse httpServletResponse    //   include inside method parameter
//		Cookie cookie = new Cookie("lcApp.username", userInfoDTO.getUsername());
//		cookie.setMaxAge(60*60*24); 			// write the time in minutes
//		
//		// add the cookie to the response
//		httpServletResponse.addCookie(cookie);
		
		
		
		
		
		// calculate love percentage between two names
		
		
		
		
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

