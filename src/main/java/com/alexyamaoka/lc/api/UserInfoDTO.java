package com.alexyamaoka.lc.api;

import javax.validation.constraints.NotBlank;

public class UserInfoDTO {
	
	// data transfer object 
	
	@NotBlank(message = " * username cannot be blank")	
	private String username;
	private String crushName;
	
	
	public UserInfoDTO() {
		// example used for data binding
		//this.username = "user name demo";
		//this.crushName = "crush name demo";
		System.out.println("User Info DTO constructor called");
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getCrushName() {
		return crushName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	@Override
	public String toString() {
		return "UserInfoDTO [username=" + username + ", crushName=" + crushName + "]";
	}
}
