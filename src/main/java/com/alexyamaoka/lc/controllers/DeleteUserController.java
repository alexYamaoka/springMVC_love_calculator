package com.alexyamaoka.lc.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexyamaoka.lc.api.UserRegistrationDTO;
import com.alexyamaoka.lc.database.RegisteredUsersDAO;

@Controller
public class DeleteUserController {
	
	@Autowired
	private RegisteredUsersDAO registeredUsersDAO;
	
	@RequestMapping("/delete-user")
	public String deleteRegisteredUser() {
		
		
		return "delete-user-page";
	}
	
	
	@RequestMapping("/process-delete-user")
	public String processDeleteUser(@RequestParam String username, Model model) {
		
		System.out.println("username to be deleted: " + username);
		
		
		try {
			registeredUsersDAO.deleteUserByName(username);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("username not found");
			e.printStackTrace();
		}
		model.addAttribute("username", username);
		
		
		return "delete-user-success";
	}
}
