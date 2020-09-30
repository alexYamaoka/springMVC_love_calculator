package com.alexyamaoka.lc.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexyamaoka.lc.api.UserInfoDTO;
import com.alexyamaoka.lc.api.UserRegistrationDTO;
import com.alexyamaoka.lc.database.RegisteredUsersDAO;

@Controller
public class LoginController {
	
	@Autowired
	RegisteredUsersDAO registeredUsersDao;
	
	
	//private List<UserRegistrationDTO> usersList;
	private Map<String, UserRegistrationDTO> usersMap;
	
	
	
	@RequestMapping("/login")
	public String showLoginPage() {
		
		return "login";
	}
	
	
	@RequestMapping("/process-login")
	public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
		
		System.out.println("login username: " + username);
		System.out.println("login password: " + password);
		
		
		try {
			getUsersFromDB();
			
			if (username.equals("alex_123") && new String(password).equals("123123")) {
				return "admin";
			}
			
			
			if (usersMap.containsKey(username)) {
				
				UserRegistrationDTO user = usersMap.get(username);
				if (new String(user.getPassword()).equals(password)) {
					model.addAttribute("userInfoDTO", new UserInfoDTO());
					return "home-page";
				}
				
			}
//			for (UserRegistrationDTO user: usersMap) {
//				
//				
//				if (user.getUsername().equals(username) && new String(user.getPassword()).equals(password)) {
//					
//					model.addAttribute("userInfoDTO", new UserInfoDTO());
//					return "home-page";
//				}
//			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			System.out.println("error from getUsersFromDB");
			e.printStackTrace();
		}
		
		
		System.out.println("Incorrect username or password");
		return "login";
	}
	
	
	private void getUsersFromDB() throws ClassNotFoundException, SQLException {
		
		 usersMap = registeredUsersDao.viewAllRegisteredUsers();

	}
}









