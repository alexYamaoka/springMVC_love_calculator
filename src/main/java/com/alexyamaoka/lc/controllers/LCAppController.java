package com.alexyamaoka.lc.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alexyamaoka.lc.api.UserInfoDTO;
import com.alexyamaoka.lc.service.LCAppService;
import com.alexyamaoka.lc.service.LCAppServiceImpl;

@Controller
@SessionAttributes({"userInfoDTO"})	
public class LCAppController {
	
	@Autowired
	private LCAppServiceImpl lcAppServiceImpl;
	
	@RequestMapping("/")
	public String showHomePage(Model model) {   
		// read the existing property by fetching it from the dto 
		
		
		// whenever spring is going to put userInfoDTO inside the modelAttribute, it is also going to put it in the session
		// whenever we have @modelAttribute, need to put userInfoDTO manually using model
		model.addAttribute("userInfoDTO", new UserInfoDTO());
		
		
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
	public String showResultPage(Model model, @Valid UserInfoDTO userInfoDTO, BindingResult bindingResult) {		
		// Spring binds the data automatically from the url 
		// writing the value to the properties by fetching from the url
		
		// by writing BindingResult right behind UserInfoDTO, spring will automatically bind the results to userInfoDTO
		
		model.addAttribute("userInfoDTO", userInfoDTO);
		
		
		
		System.out.println(userInfoDTO.isAgreedToTermsAndCondition());
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError oe: allErrors) {
				System.out.println(oe);
			}
			
			return "home-page";
		}
	
		// calculate love percentage between two names
		String result = lcAppServiceImpl.calculateLove(userInfoDTO.getUsername(), userInfoDTO.getCrushName());
		userInfoDTO.setResult(result);
		
		
		return "result-page";
	}	
	
	
	
	
	
	
	
	
}



// if its a new user, create a new session. if returning user, retrieve cookie
// this attribute is available among all jsp or controller pages
// by default, the session objects are stored inside the server memory - deleted once the server is stopped

// HttpServletRequest httpServletRequest   // include in method parameter
//HttpSession httpSession = httpServletRequest.getSession();
//httpSession.setAttribute("username", userInfoDTO.getUsername());
//httpSession.setMaxInactiveInterval(120);




//// create a cookie for the username
// HttpServletResponse httpServletResponse    //   include inside method parameter
//Cookie cookie = new Cookie("lcApp.username", userInfoDTO.getUsername());
//cookie.setMaxAge(60*60*24); 			// write the time in minutes
//
//// add the cookie to the response
//httpServletResponse.addCookie(cookie);




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

